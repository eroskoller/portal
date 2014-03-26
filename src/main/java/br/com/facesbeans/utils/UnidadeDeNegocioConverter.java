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

@FacesConverter(value="unidadedenegocioconverter")
public class UnidadeDeNegocioConverter   implements Converter,Serializable{

    private PortalView portal;
    public static List<UnidadeDeNegocio> unidadeDeNegocioDB;
    
    static{
        unidadeDeNegocioDB = new ArrayList<UnidadeDeNegocio>();
        unidadeDeNegocioDB.add(new UnidadeDeNegocio("", "------"));
        unidadeDeNegocioDB.add(new UnidadeDeNegocio("NTO", "NTO"));
        unidadeDeNegocioDB.add(new UnidadeDeNegocio("NTH", "NTH"));
        unidadeDeNegocioDB.add(new UnidadeDeNegocio("Hospitais", "Hospitais"));
        unidadeDeNegocioDB.add(new UnidadeDeNegocio("Administrativo", "Administrativo"));
    }

    public UnidadeDeNegocioConverter() {
           portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                String codigo = submittedValue;

                for (UnidadeDeNegocio un : unidadeDeNegocioDB) {
                    if (un.getCodigo().equalsIgnoreCase(codigo) ) {
                        portal.popMsg(9999, false, "Selecionado nova Unidade de Negocio ...  :  "+codigo);
                        return un;
                    }
                }
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Centro de Custo"));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((UnidadeDeNegocio) value).getCodigo());
        }
    }
    
}
