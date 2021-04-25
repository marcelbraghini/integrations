package br.com.marcelbraghini.adapters.controller;

import br.com.marcelbraghini.entities.endereco.Endereco;
import br.com.marcelbraghini.entities.exceptions.EnderecoErpException;
import br.com.marcelbraghini.infrastructure.correios.atendecliente.EnderecoERP;
import br.com.marcelbraghini.usecases.endereco.EnderecoUsecase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoResourceTest {

    @InjectMocks
    private EnderecoResource enderecoResource;

    @Mock
    private EnderecoUsecase enderecoUsecase;

    @Test
    public void ShouldReturnEnderecoWithSuccess() {
        final EnderecoERP enderecoERP = new EnderecoERP();
        enderecoERP.setCep("88888888");
        enderecoERP.setEnd("Rua das Alamedas");
        enderecoERP.setComplemento2("");
        enderecoERP.setBairro("Centro");
        enderecoERP.setCidade("Chapecó");
        enderecoERP.setUf("SC");

        when(enderecoUsecase.getEnderecoERP(anyString())).thenReturn(enderecoERP);

        Response response = enderecoResource.getEndereco("88888888");
        Endereco endereco = (Endereco) response.getEntity();

        assertEquals(Response.Status.OK, response.getStatusInfo());
        assertEquals(enderecoERP.getCep(), endereco.getCep());
        assertEquals(enderecoERP.getUf(), endereco.getUf());
        assertEquals(enderecoERP.getCidade(), endereco.getCidade());
    }

    @Test
    public void shouldReturnThrownEnderecoErpException() {
        when(enderecoUsecase.getEnderecoERP(anyString())).thenReturn(null);

        assertThrows(EnderecoErpException.class, () -> enderecoResource.getEndereco("88888888"));
    }
}
