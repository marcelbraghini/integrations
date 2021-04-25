package br.com.marcelbraghini.entities.exceptions;

public class EnderecoErpException extends RuntimeException{

    private final String cep;

    public EnderecoErpException(final Throwable throwable, final String cep) {
        super(throwable);
        this.cep = cep;
    }

    public EnderecoErpException() {
        this.cep = "";
    }

    public String getCepWhenThrown() {
        return cep;
    }
}
