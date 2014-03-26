/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.hibernate.entities.LabDetalheRequisicao;
import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author eros
 */
public class LabRequisicaoBean implements Serializable{
    
    
    private PortalView portal;
    private LabRequisicao labRequisicao;
    private  List<LabDetalheRequisicaoBean> listLabDetalheRequisicaoBeans;

    public LabRequisicaoBean(PortalView portal, LabRequisicao labRequisicao) {
        this.portal = portal;
        this.labRequisicao = labRequisicao;
    }

    public PortalView getPortal() {
        return portal;
    }

    public void setPortal(PortalView portal) {
        this.portal = portal;
    }

    public LabRequisicao getLabRequisicao() {
        return labRequisicao;
    }

    public void setLabRequisicao(LabRequisicao labRequisicao) {
        this.labRequisicao = labRequisicao;
    }

    public List<LabDetalheRequisicaoBean> getListLabDetalheRequisicaoBeans() {
        if(this.labRequisicao != null  && listLabDetalheRequisicaoBeans == null && portal != null){
            List<LabDetalheRequisicao>  listLabDetalheRequisicaoFiltrado =
                    OracleHelper.getListOfObjectByKeyEq(LabDetalheRequisicao.class, "reqStCodigo", this.labRequisicao.getReqStCodigo(), "reqStCodigo", true,portal.getStrDbName());
            if(listLabDetalheRequisicaoFiltrado != null && listLabDetalheRequisicaoFiltrado.size() > 0){
                listLabDetalheRequisicaoBeans = new ArrayList<LabDetalheRequisicaoBean>(listLabDetalheRequisicaoFiltrado.size());
                for(LabDetalheRequisicao ldr : listLabDetalheRequisicaoFiltrado){
                    listLabDetalheRequisicaoBeans.add(new LabDetalheRequisicaoBean(ldr.getDerInCodigo(), portal, ldr));
                }
            }
            
        }
        return listLabDetalheRequisicaoBeans;
    }

    public void setListLabDetalheRequisicaoBeans(List<LabDetalheRequisicaoBean> listLabDetalheRequisicaoBeans) {
        this.listLabDetalheRequisicaoBeans = listLabDetalheRequisicaoBeans;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.labRequisicao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabRequisicaoBean other = (LabRequisicaoBean) obj;
        if (!Objects.equals(this.labRequisicao, other.labRequisicao)) {
            return false;
        }
        return true;
    }
    
    
    
}
