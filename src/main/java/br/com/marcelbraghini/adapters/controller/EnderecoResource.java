package br.com.marcelbraghini.adapters.controller;

import br.com.marcelbraghini.entities.endereco.Endereco;
import br.com.marcelbraghini.entities.exceptions.EnderecoErpException;
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
import java.util.Arrays;
import java.util.Objects;

import static java.lang.String.format;

@Path("/v1/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    private static final Logger logger = Logger.getLogger(EnderecoResource.class);

    @Inject
    EnderecoUsecase enderecoUsecase;

    @GET
    @Path("/{cep}")
    @Retry(maxRetries = 3, delay = 3000)
    public Response getEndereco(@PathParam("cep") String cep) {
        try {
            final EnderecoERP enderecoERP = enderecoUsecase.getEnderecoERP(cep);

            if (Objects.isNull(enderecoERP)){
                return Response.status(Response.Status.NO_CONTENT).build();
            }

            final Endereco endereco = convertToEndereco(enderecoERP);

            logger.info(format("[EnderecoResource:getEndereco] For the cep %s = %s", cep, endereco));

            return Response.ok(endereco).build();
        } catch (final EnderecoErpException e) {
            logger.error(format("[EnderecoResource:getEndereco] EnderecoErpException for the cep %s with error: %s",
                    e.getCepWhenThrown(), e.getMessage()));
//            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (final Exception e) {
            logger.error(format("[EnderecoResource:getEndereco] Exception for the cep %s with error: %s",
                    cep, e.getMessage()));
//            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private Endereco convertToEndereco(final EnderecoERP enderecoERP){
        if (enderecoERP == null) {
            throw new EnderecoErpException();
        }

        return new Endereco.Builder(enderecoERP.getCep())
                            .withEndereco(enderecoERP.getEnd())
                            .withComplemento(enderecoERP.getComplemento2())
                            .withBairro(enderecoERP.getBairro())
                            .withCidade(enderecoERP.getCidade())
                            .withUf(enderecoERP.getUf())
                            .build();
    }

}