package br.com.marcelbraghini.adapters.controller;

import br.com.marcelbraghini.entities.endereco.Endereco;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.EnderecoERP;
import br.com.marcelbraghini.usecases.endereco.EnderecoUsecase;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/v1/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    private static final Logger logger = Logger.getLogger(EnderecoResource.class);

    @Inject
    private EnderecoUsecase enderecoUsecase;

    @GET
    @Path("/{cep}")
    @Retry(maxRetries = 3, delay = 3000)
    public Response getEndereco(@PathParam("cep") String cep) {

        final Endereco endereco = convertToEndereco(enderecoUsecase.getEnderecoERP(cep));

        if (Objects.isNull(endereco)){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        logger.info(String.format("[EnderecoResource:getEndereco] For the cep %s = %s", cep, endereco));

        return Response.ok(endereco).build();
    }

    private Endereco convertToEndereco(final EnderecoERP enderecoERP){
        return new Endereco.Builder(enderecoERP.getCep())
                            .withEndereco(enderecoERP.getEnd())
                            .withComplemento(enderecoERP.getComplemento2())
                            .withBairro(enderecoERP.getBairro())
                            .withCidade(enderecoERP.getCidade())
                            .withUf(enderecoERP.getUf())
                            .build();
    }

}