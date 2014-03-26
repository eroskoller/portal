/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import br.com.facesbeans.reports.ErpEstatisticaGeralView;
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
@FacesConverter(value="centrocustoconverter")
public class CentroDeCustoConverter implements Converter,Serializable{

    private PortalView portal;
    
    public static List<CentroDeCusto> centroCustoDB;
    static{
        centroCustoDB = new ArrayList<CentroDeCusto>();
        centroCustoDB.add(new CentroDeCusto("99999", "-------------"));
        centroCustoDB.add(new CentroDeCusto("01", "Cadastro"));
        centroCustoDB.add(new CentroDeCusto("02", "Coleta"));
        centroCustoDB.add(new CentroDeCusto("03", "Administrativo"));
        centroCustoDB.add(new CentroDeCusto("07", "Área Técnica"));
        centroCustoDB.add(new CentroDeCusto("08", "Setor Hospitalar"));
    }

    public CentroDeCustoConverter() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }
    
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                String codigo = submittedValue;

                for (CentroDeCusto cc : centroCustoDB) {
                    if (cc.getCodigo().equalsIgnoreCase(codigo) ) {
                        
                        if(cc.getCodigo().equalsIgnoreCase("99999")){
                             ErpEstatisticaGeralView erpEstatisticaGeralView = (ErpEstatisticaGeralView) JSFHelper.getSessionAttribute("erpEstatisticaGeralViewBean");
                             erpEstatisticaGeralView.getListSelectedCentroDeCusto().clear();
                             portal.popMsg(1, true, "Limpando lista de Tipos de Centro de Custo  ");
                            return new Object();
                        }else{
                            portal.popMsg(9999, false, "Selecionado novo Centro de Custo ...   :  "+codigo);
                            return cc;
                        }
                        
                    }
                }
                
            } catch(NumberFormatException exception) {
//                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Centro de Custo"));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value.equals("")) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return "";
        } else {
            return String.valueOf(((CentroDeCusto) value).getCodigo());
        }
    }
    
}
