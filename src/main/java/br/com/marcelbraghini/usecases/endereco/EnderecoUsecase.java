package br.com.marcelbraghini.usecases.endereco;

import br.com.marcelbraghini.entities.exceptions.EnderecoErpException;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.AtendeCliente;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.EnderecoERP;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EnderecoUsecase {

    private static final Logger logger = Logger.getLogger(EnderecoUsecase.class);

    @Inject
    AtendeCliente atendeCliente;

    public EnderecoERP getEnderecoERP(final String cep) {
        try {
            return atendeCliente.consultaCEP(cep);
        } catch (Exception e) {
            logger.error(String.format("[EnderecoUsecase:getEnderecoERP] For the cep %s", cep));

            throw new EnderecoErpException(e, cep);
        }
    }
}
