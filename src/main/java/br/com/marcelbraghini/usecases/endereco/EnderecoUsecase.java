package br.com.marcelbraghini.usecases.endereco;

import br.com.marcelbraghini.entities.exceptions.EnderecoErpException;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.AtendeCliente;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.EnderecoERP;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EnderecoUsecase {

    @Inject
    AtendeCliente atendeCliente;

    public EnderecoERP getEnderecoERP(final String cep) {
        try {
            return atendeCliente.consultaCEP(cep);
        } catch (Exception e) {
            throw new EnderecoErpException(e, cep);
        }
    }
}
