/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import br.com.hibernate.entities.ErpEstabelecimento;
import br.com.hibernate.entities.ErpEstabelecimentoPK;
import br.com.hibernate.entities.ErpRegional;
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
@FacesConverter(value="erpetabelecimentoconverter")
public class ErpEstabelecimentoConverter implements Serializable,Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {

                XStream xstream = new XStream();
                xstream.alias("ErpEstabelecimento", ErpEstabelecimento.class);
                return  (ErpEstabelecimento) xstream.fromXML(submittedValue);
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Estabelecimento"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ErpEstabelecimento) value).toString());
        }
    }

}
