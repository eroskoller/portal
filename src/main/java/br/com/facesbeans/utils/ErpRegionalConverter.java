/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import br.com.hibernate.entities.ErpRegional;
import br.com.hibernate.entities.ErpRegionalPK;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import com.thoughtworks.xstream.XStream;
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
@FacesConverter(value="erpregionalconverter")
public class ErpRegionalConverter   implements Serializable,Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {

                XStream xstream = new XStream();
                xstream.alias("ErpRegional", ErpRegional.class);
//                ErpRegionalPK pk = (ErpRegionalPK) xstream.fromXML(submittedValue);
//                return  (ErpRegional)OracleHelper.getObject(ErpRegional.class, pk, ((PortalView) JSFHelper.getSessionAttribute("portalViewBean")).getStrDbName());
                return  (ErpRegional) xstream.fromXML(submittedValue);
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Centro de Custo"));
            }
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ErpRegional) value).toString());
        }
    }
    
}
