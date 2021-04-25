package br.com.marcelbraghini.usecases.endereco;

import br.com.marcelbraghini.entities.exceptions.EnderecoErpException;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.AtendeCliente;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.EnderecoERP;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.SQLException_Exception;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.SigepClienteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoUsecaseTest {

    @InjectMocks
    private EnderecoUsecase enderecoUsecase;

    @Mock
    private AtendeCliente atendeCliente;

    @Test
    public void shouldRetrieveEnderecoWithSuccess() throws SigepClienteException, SQLException_Exception {
        final EnderecoERP enderecoERP = new EnderecoERP();
        enderecoERP.setCep("88888888");
        enderecoERP.setEnd("Rua das Alamedas");
        enderecoERP.setComplemento2("");
        enderecoERP.setBairro("Centro");
        enderecoERP.setCidade("Chapecó");
        enderecoERP.setUf("SC");

        when(atendeCliente.consultaCEP(anyString())).thenReturn(enderecoERP);

        assertDoesNotThrow(() -> enderecoUsecase.getEnderecoERP("89883000"));
    }

    @Test
    public void shouldReturnThrownException() throws SigepClienteException, SQLException_Exception {
        when(atendeCliente.consultaCEP(anyString())).thenThrow(new RuntimeException());

        assertThrows(Exception.class, () -> enderecoUsecase.getEnderecoERP("89883000"));
    }

    @Test
    public void shouldReturnThrownEnderecoErpException() throws SigepClienteException, SQLException_Exception {
        when(atendeCliente.consultaCEP(anyString())).thenThrow(new EnderecoErpException());

        assertThrows(EnderecoErpException.class, () -> enderecoUsecase.getEnderecoERP("89883000"));
    }

}
