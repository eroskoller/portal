///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.facesbeans.jobpush;
//
//import br.com.facesbeans.utils.JSFHelper;
//import br.com.hibernate.entities.LabRelatorios;
////import br.com.hibernate.entities.mysql.RelatorioDados;
////import br.com.hibernate.utils.mysql.MySQLHelper;
//import br.com.hibernate.utils.OracleHelper;
//import br.com.portal.beans.login.PortalView;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;
//import org.primefaces.context.RequestContext;
//
///**
// *
// * @author eros
// */
//@ApplicationScoped
//@ManagedBean(name = "relatorioPush")
//public class RelatorioPush implements Serializable {
//
////    private LabUsuario labUser;
////    private List<RelatorioDados> listRelDados;
////    protected Effect valueChangeEffectRelatorioDados;
//    private String strContentPath;
//    private boolean blSortData = false;
//    private boolean blSortDataTerm = false;
//    private boolean blSortStatus = false;
//    private boolean blSortName = false;
//    private boolean blSortNew = false;
//    private PortalView portal;
//
//    public RelatorioPush() {
//        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
////           valueChangeEffectRelatorioDados = new Highlight("#268CCD");
////           valueChangeEffectRelatorioDados.setFired(true);
//
//        strContentPath = JSFHelper.getExternalContext().getRequestContextPath(); //context.getExternalContext().getRequestContextPath();
//
////           if (lmi != null  && lmi.getUsuario() != null) {
////           }else{
////               try {
////                    JSFHelper.getExternalContext().redirect("/index.jsp");//                    JSFHelper.getExternalContext().redirect("index.jsp");
////
////                } catch (IOException ex) {
////                    Logger.getLogger(RelatorioPush.class.getName()).log(Level.SEVERE, null, ex);
////                }
////           }
//
//    }
//
//    public String getStrContentPath() {
//        return strContentPath;
//    }
//
//    public void setStrContentPath(String strContentPath) {
//        this.strContentPath = strContentPath;
//    }
//
////    public Effect getValueChangeEffectRelatorioDados() {
////        return valueChangeEffectRelatorioDados;
////    }
////
////    public void setValueChangeEffectRelatorioDados(Effect valueChangeEffectRelatorioDados) {
////        this.valueChangeEffectRelatorioDados = valueChangeEffectRelatorioDados;
////    }
//    public List<LabRelatorios> getListRelDados() {
//
//        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        if (portal != null && portal.getLabUsuario() != null) {
//            String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//            return RelatorioStorage.getMapRelStorage().get(id);
//        }
//        return new ArrayList<LabRelatorios>();
//
//    }
//
//    public int getAmountOfReports() {
//        int retorno = 0;
//        if (getListRelDados() != null && !getListRelDados().isEmpty()) {
//            retorno = getListRelDados().size();
//        }
//        return retorno;
//    }
//
//    public void refreshTableRel() {
//        if (this.getListRelDados() != null && !this.getListRelDados().isEmpty()) {
//
//            for (int i = 0; i < this.getListRelDados().size(); i++) {
//                LabRelatorios rd = this.getListRelDados().get(i);
////               System.out.println("inside loop refreshTableRel.........");
//                if (rd.getRelChStatus().toString().equalsIgnoreCase("L")) {
////                   System.out.println("FOUND A MATCH........................");
////                   rd = 
//                    this.getListRelDados().remove(i);
//                    this.getListRelDados().add(i, (LabRelatorios) OracleHelper.getObject(LabRelatorios.class, rd.getRelInCodigo(), portal.getStrDbName()));
//                }
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
////        Collections.sort(this.relatorioPush.getListRelDados(), RelatorioDados.ID_COMPARATOR9To1);
//              RelatorioPush   relPush = (RelatorioPush) JSFHelper.getApplicationAttribute("relatorioPush");
//              RequestContext.getCurrentInstance().push("listRelDados", relPush.getListRelDados());  
//    }
//
//    public void sortRelByDate() {
//
//
//        if (portal == null) {
//            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        }
//
//        String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//
//        if (RelatorioStorage.getMapRelStorage().get(id) != null
//                && !RelatorioStorage.getMapRelStorage().get(id).isEmpty()
//                && RelatorioStorage.getMapRelStorage().get(id).size() > 1) {
//
//
//            RelatorioStorage.sortRelByDate(portal.getStrLogin().toUpperCase(), portal.getStrDbName().toUpperCase(), blSortData);
//
//            if (blSortData) {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.DATAPESQ_COMPARATOR_1_0);
//                blSortData = false;
//            } else {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.DATAPESQ_COMPARATOR_0_1);
//                blSortData = true;
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
//    }
//
//    public void sortRelByDateTerm() {
//
//        if (portal == null) {
//            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        }
//        String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//
//        //lmi.getUsuario().getUsuStCodigo()
//        if (RelatorioStorage.getMapRelStorage().get(id) != null
//                && !RelatorioStorage.getMapRelStorage().get(id).isEmpty()
//                && RelatorioStorage.getMapRelStorage().get(id).size() > 1) {
//
//            RelatorioStorage.sortRelByDateTerm(portal.getStrLogin().toUpperCase(), portal.getStrDbName().toUpperCase(), blSortDataTerm);
//
//            if (blSortDataTerm) {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.DATATERM_COMPARATOR_1_0);
//                blSortDataTerm = false;
//            } else {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.DATATERM_COMPARATOR_0_1);
//                blSortDataTerm = true;
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
//    }
//
//    public void sortRelByStatus() {
//
//        if (portal == null) {
//            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        }
//        String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//
//        if (RelatorioStorage.getMapRelStorage().get(id) != null
//                && !RelatorioStorage.getMapRelStorage().get(id).isEmpty()
//                && RelatorioStorage.getMapRelStorage().get(id).size() > 1) {
//
//
//            RelatorioStorage.sortRelByStatus(portal.getStrLogin().toUpperCase(), portal.getStrDbName().toUpperCase(), blSortStatus);
//            if (blSortStatus) {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.STATUS_COMPARATORATOR_A_Z);
//                blSortStatus = false;
//            } else {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.STATUS_COMPARATORATOR_Z_A);
//                blSortStatus = true;
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
//    }
//
//    public void sortRelByNew() {
//
//        if (portal == null) {
//            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        }
//        String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//
//        if (RelatorioStorage.getMapRelStorage().get(id) != null
//                && !RelatorioStorage.getMapRelStorage().get(id).isEmpty()
//                && RelatorioStorage.getMapRelStorage().get(id).size() > 1) {
//
//            RelatorioStorage.sortRelByNew(portal.getStrLogin().toUpperCase(), portal.getStrDbName().toUpperCase(), blSortNew);
//
//            if (blSortNew) {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.NEW_COMPARATORATOR_A_Z);
//                blSortNew = false;
//            } else {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.NEW_COMPARATORATOR_Z_A);
//                blSortNew = true;
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
//    }
//
//    public void sortRelByName() {
//
//        if (portal == null) {
//            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        }
//        String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//
//        if (RelatorioStorage.getMapRelStorage().get(id) != null
//                && !RelatorioStorage.getMapRelStorage().get(id).isEmpty()
//                && RelatorioStorage.getMapRelStorage().get(id).size() > 1) {
//
//            RelatorioStorage.sortRelByName(portal.getStrLogin().toUpperCase(), portal.getStrDbName().toUpperCase(), blSortName);
//
//            if (blSortName) {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.PDFNAME_COMPARATORATOR_A_Z);
//
//                blSortName = false;
//            } else {
////                Collections.sort(RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()), LabRelatorios.PDFNAME_COMPARATORATOR_Z_A);
//                blSortName = true;
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
//    }
//
//    public void sortRelById() {
//
//        if (portal == null) {
//            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        }
//        String id = portal.getStrLogin().toUpperCase() + portal.getStrDbName().toUpperCase();
//
//        if (RelatorioStorage.getMapRelStorage().get(id) != null
//                && !RelatorioStorage.getMapRelStorage().get(id).isEmpty()
//                && RelatorioStorage.getMapRelStorage().get(id).size() > 1) {
//
//            RelatorioStorage.sortRelByID(portal.getStrLogin().toUpperCase(), portal.getStrDbName().toUpperCase(), true);
//
//            if (blSortName) {
//                blSortName = false;
//            } else {
//                blSortName = true;
//            }
//        }
////        valueChangeEffectRelatorioDados.setFired(false);
//    }
//}
