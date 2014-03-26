/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import br.com.hibernate.entities.ErpCcusto;
import br.com.hibernate.entities.ErpMarcas;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
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
@FacesConverter(value="erpcentrodecustoconverter")
public class ErpCcustoConverter implements Serializable,Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                 return (ErpCcusto)OracleHelper.getObject(ErpCcusto.class, submittedValue, ((PortalView) JSFHelper.getSessionAttribute("portalViewBean")).getStrDbName());
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid ErpCcusto"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ErpCcusto) value).getCcuStCodigo());
        }
    }
    
}
