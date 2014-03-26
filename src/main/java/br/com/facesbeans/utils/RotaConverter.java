/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import br.com.facesbeans.reports.ErpEstatisticaGeralView;
import br.com.portal.beans.login.PortalView;
import br.com.utils.tipstricks.ZerosFabrica;
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

@FacesConverter(value="rotaconverter")  
public class RotaConverter implements Converter,Serializable{
    
    private PortalView portal;
    
    public static List<Rota> rotaDB;
    static{
        rotaDB = new ArrayList<Rota>();
        rotaDB.add(new Rota("99999", "-------"));
        for (int i = 1; i < 101; i++) {
            rotaDB.add(new Rota(ZerosFabrica.makeZeros(new Integer(i).toString(), 3), ZerosFabrica.makeZeros(new Integer(i).toString(), 3)));
        }
    }

    public RotaConverter() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }
    
    
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                String codigo = submittedValue;

                for (Rota rt : rotaDB) {
                    if (rt.getCodigo().equalsIgnoreCase(codigo) ) {
                        if(rt.getCodigo().equalsIgnoreCase("99999")){
                            ErpEstatisticaGeralView erpEstatisticaGeralView = (ErpEstatisticaGeralView) JSFHelper.getSessionAttribute("erpEstatisticaGeralViewBean");
                            erpEstatisticaGeralView.getListSelectedRota().clear();
                            portal.popMsg(1, true, "Limpando lista de Rotas  ");
                            return  null;
                        }else{
                            portal.popMsg(9999, false, "Selecionado nova Rota ...   :  "+codigo);
                            return rt;
                        }
                        
                    }
                }
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Rota"));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Rota) value).getCodigo());
        }
    }
    
}
