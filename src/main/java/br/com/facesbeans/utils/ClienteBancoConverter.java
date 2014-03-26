/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author eros
 */
@FacesConverter(value="clientebancoconverter")
public class ClienteBancoConverter implements Serializable,Converter{
    
    
    private PortalView portal;
    
    public static List<ClienteBanco> clienteBancoDB;
    static{
        clienteBancoDB = new ArrayList<ClienteBanco>();
        clienteBancoDB.add(new ClienteBanco("", "-------------"));
        clienteBancoDB.add(new ClienteBanco("1001", "PARANALISE"));
        clienteBancoDB.add(new ClienteBanco("1002", "FLEMING"));
        clienteBancoDB.add(new ClienteBanco("1003", "UNION"));
        clienteBancoDB.add(new ClienteBanco("1004", "EXCELENCIA"));
        clienteBancoDB.add(new ClienteBanco("1005", "LAMBERT"));
        clienteBancoDB.add(new ClienteBanco("1006", "LCC"));
        clienteBancoDB.add(new ClienteBanco("1007", "LABCLIM"));
        clienteBancoDB.add(new ClienteBanco("1008", "FARES"));
    }

    public ClienteBancoConverter() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }
    
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                String codigo = submittedValue;

                for (ClienteBanco cdb : clienteBancoDB) {
                    if (cdb.getCodigo().equalsIgnoreCase(codigo) ) {
                        portal.popMsg(9999, false, "Selecionado novo Cliente do Banco ...   :  "+codigo);
                        return cdb;
                    }
                }
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Não é um Cliente valido..............."));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ClienteBanco) value).getCodigo());
        }
    }
    
}
