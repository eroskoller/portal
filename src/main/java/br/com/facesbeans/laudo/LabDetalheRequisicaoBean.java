/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.facesbeans.shared.ArrayItems;
import br.com.hibernate.entities.LabDetalheRequisicao;
import br.com.hibernate.entities.LabExame;
import br.com.hibernate.entities.LabResultados;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eros
 */
public class LabDetalheRequisicaoBean implements Serializable{
    
    private List<LabResultadoBean> listLabResultadoBean;
    private Long longDerInCodigo;
    private PortalView portal;
    private LabDetalheRequisicao  labDetalheRequisicao;
    private LabExame labExame;
    private String statusCalculado;

    public LabDetalheRequisicaoBean() {
    }

    public LabDetalheRequisicaoBean(Long longDerInCodigo, PortalView portal, LabDetalheRequisicao labDetalheRequisicao) {
        this.longDerInCodigo = longDerInCodigo;
        this.portal = portal;
        this.labDetalheRequisicao = labDetalheRequisicao;
    }

    public LabDetalheRequisicao getLabDetalheRequisicao() {
        return labDetalheRequisicao;
    }

    public void setLabDetalheRequisicao(LabDetalheRequisicao labDetalheRequisicao) {
        this.labDetalheRequisicao = labDetalheRequisicao;
    }

    

    public Long getLongDerInCodigo() {
        return longDerInCodigo;
    }

    public void setLongDerInCodigo(Long longDerInCodigo) {
        this.longDerInCodigo = longDerInCodigo;
    }
    

    public PortalView getPortal() {
        return portal;
    }

    public void setPortal(PortalView portal) {
        this.portal = portal;
    }

    public String getStatusCalculado() {
        if(statusCalculado ==  null && labDetalheRequisicao != null && labDetalheRequisicao.getLegStCodigo() != null && ArrayItems.getMapLabLegendaConsultaLaudo().containsKey(labDetalheRequisicao.getLegStCodigo() )){
            statusCalculado = ArrayItems.getMapLabLegendaConsultaLaudo().get(labDetalheRequisicao.getLegStCodigo()).getLegStDescricao();
        }else{
            statusCalculado = ArrayItems.getMapLabLegendaConsultaLaudo().get("999").getLegStDescricao();
        }
        return statusCalculado;
    }

    public void setStatusCalculado(String statusCalculado) {
        this.statusCalculado = statusCalculado;
    }
    

    public LabExame getLabExame() {
        if(labExame == null && labDetalheRequisicao != null  && portal != null){
            labExame = (LabExame) OracleHelper.getObject(LabExame.class, labDetalheRequisicao.getExaStCodigo(), portal.getStrDbName());
        }
        return labExame;
    }

    public void setLabExame(LabExame labExame) {
        this.labExame = labExame;
    }
    
    
    
//    public List<LabResultado> getListLabResultadoses() {
//        if(listLabResultados == null && longDerInCodigo != null  && portal != null ){
//            listLabResultados = OracleHelper.getListLabResultados(longDerInCodigo,portal.getStrDbName());
//        }
//        return listLabResultados;
//    }
//    public void setListLabResultados(List<LabResultados> listLabResultados) {
//        this.listLabResultados = listLabResultados;
//    }

    public List<LabResultadoBean> getListLabResultadoBean() {
        if(listLabResultadoBean == null && longDerInCodigo != null  && portal != null ){
            List <LabResultados> list = OracleHelper.getListLabResultados(longDerInCodigo,portal.getStrDbName());
            if(list != null && ! list.isEmpty()){
                listLabResultadoBean = new ArrayList<>(list.size());
                for(LabResultados lr : list){
                    listLabResultadoBean.add(new LabResultadoBean(portal, lr));
                }
            }
        }
        return listLabResultadoBean;
    }

    public void setListLabResultadoBean(List<LabResultadoBean> listLabResultadoBean) {
        this.listLabResultadoBean = listLabResultadoBean;
    }

    
    public Integer getFlagCount(){
        getListLabResultadoBean();
        Integer count = 0;
        if(listLabResultadoBean != null && !listLabResultadoBean.isEmpty()){
            for (LabResultadoBean lBean : listLabResultadoBean) {
                if(lBean.getLabResultado() != null&& lBean.getLabResultado().getResStFlag() != null){
                    count +=  new Integer (lBean.getLabResultado().getResStFlag()); 
                }
                
            }
        }
        return count;
    }
    
    
}
