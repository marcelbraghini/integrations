
package br.com.marcelbraghini.infrastructure.correios.atendecliente;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-04-24T17:06:19.382-03:00
 * Generated source version: 3.4.2
 */

@WebFault(name = "SigepClienteException", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
public class SigepClienteException extends java.lang.Exception {

    private java.lang.String faultInfo;

    public SigepClienteException() {
        super();
    }

    public SigepClienteException(String message) {
        super(message);
    }

    public SigepClienteException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SigepClienteException(String message, java.lang.String sigepClienteException) {
        super(message);
        this.faultInfo = sigepClienteException;
    }

    public SigepClienteException(String message, java.lang.String sigepClienteException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = sigepClienteException;
    }

    public java.lang.String getFaultInfo() {
        return this.faultInfo;
    }
}
