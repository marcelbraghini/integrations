
package br.com.marcelbraghini.infrastructure.correios.atendecliente;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-04-24T17:06:19.306-03:00
 * Generated source version: 3.4.2
 */

@WebFault(name = "SQLException", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
public class SQLException_Exception extends java.lang.Exception {

    private br.com.marcelbraghini.infrastructure.correios.atendecliente.SQLException faultInfo;

    public SQLException_Exception() {
        super();
    }

    public SQLException_Exception(String message) {
        super(message);
    }

    public SQLException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SQLException_Exception(String message, br.com.marcelbraghini.infrastructure.correios.atendecliente.SQLException sqlException) {
        super(message);
        this.faultInfo = sqlException;
    }

    public SQLException_Exception(String message, br.com.marcelbraghini.infrastructure.correios.atendecliente.SQLException sqlException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = sqlException;
    }

    public br.com.marcelbraghini.infrastructure.correios.atendecliente.SQLException getFaultInfo() {
        return this.faultInfo;
    }
}