/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.facesbeans.shared.ArrayItems;
import br.com.hibernate.entities.*;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;

/**
 *
 * @author eros
 */
public class LabResultadoBean implements Serializable{
    
    
    private PortalView portal;
    private LabResultados labResultado;
    private LabConfigIngresso labConfigIngresso;
    private LabUnidadeMedida labUnidadeMedida;

    public LabResultadoBean(PortalView portal, LabResultados labResultado) {
        this.portal = portal;
        this.labResultado = labResultado;
    }

    public PortalView getPortal() {
        return portal;
    }

    public void setPortal(PortalView portal) {
        this.portal = portal;
    }
    
    public LabResultados getLabResultado() {
        return labResultado;
    }

    public void setLabResultado(LabResultados labResultado) {
        this.labResultado = labResultado;
    }

    public LabConfigIngresso getLabConfigIngresso() {
        if(labConfigIngresso == null && labResultado != null  && portal != null){
            LabConfigIngresso lci = new LabConfigIngresso();
           lci.setCinStCodigo(labResultado.getCinStCodigo());
           lci.setEmvDtValidade(labResultado.getEmvDtValidade());
           lci.setExaStCodigo(labResultado.getExaStCodigo());
           lci.setMetStCodigo(labResultado.getMetStCodigo());
        }
        return labConfigIngresso;
    }

    public void setLabConfigIngresso(LabConfigIngresso labConfigIngresso) {
        this.labConfigIngresso = labConfigIngresso;
    }

    public LabUnidadeMedida getLabUnidadeMedida() {
        if(labConfigIngresso == null && labResultado != null  && portal != null){
            labUnidadeMedida = ArrayItems.getMapLabUnidadeMedida(portal.getStrDbName()).get(labConfigIngresso.getUnmStCodigo());
        }
        return labUnidadeMedida;
    }

    public void setLabUnidadeMedida(LabUnidadeMedida labUnidadeMedida) {
        this.labUnidadeMedida = labUnidadeMedida;
    }
    
    
    
    
            
    
}
