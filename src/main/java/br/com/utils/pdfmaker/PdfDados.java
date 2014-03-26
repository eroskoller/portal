/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */

public class PdfDados implements Serializable{
    
    
    private String strDbName = "DEFAULT";
    
    
    private String strId;
    private String strResumo;
    private String strTipoDePdf;
    private String strUserNome;
    private String strPdfName;
    private String strDateFieldName;
    private Date dfStartQuery;
    private Date dtEndQuery;
    private Map<String,Object> mapAnds4Req;
    private Map<String,List> mapOrs4Req;
    private Map<String,Object> mapAnds4Det;
    private Map<String,List> mapOrs4Det;
    private String strTipoRelatorio;
    private String strOrdemDoRel;

    public PdfDados() {
    }
    
    
    

    public PdfDados(String strId, String strTipoDePdf, String strPdfName, Map<String, List> mapOrs4Det,String strDbName) {
        this.strId = strId;
        this.strTipoDePdf = strTipoDePdf;
        this.strPdfName = strPdfName;
        this.mapOrs4Det = mapOrs4Det;
        this.strDbName = strDbName;
    }
    
    public PdfDados(String strId, String strTipoDePdf, String strPdfName, Map<String, List> mapOrs4Det, String strUserName, String strResumo,String strDbName) {
        this.strId = strId;
        this.strTipoDePdf = strTipoDePdf;
        this.strPdfName = strPdfName;
        this.mapOrs4Det = mapOrs4Det;
        this.strUserNome = strUserName;
        this.strResumo = strResumo;
        this.strDbName = strDbName;
    }

    public PdfDados(String strId, String strResumo, String strUserNome, Date dfStartQuery, Date dtEndQuery, Map<String, List> mapOrs4Det, String strTipoRelatorio, String strOrdemDoRel,String strDbName) {
        this.strId = strId;
        this.strResumo = strResumo;
        this.strUserNome = strUserNome;
        this.dfStartQuery = dfStartQuery;
        this.dtEndQuery = dtEndQuery;
        this.mapOrs4Det = mapOrs4Det;
        this.strTipoRelatorio = strTipoRelatorio;
        this.strOrdemDoRel = strOrdemDoRel;
        this.strDbName = strDbName;
    }

   
    
    public PdfDados(String strPdfName,String strDateFieldName,
            String strResumo,
            String strTipoDePdf,
            Date dfStartQuery, Date dtEndQuery,
            Map<String, Object> mapAnds4Req, Map<String, List> mapOrs4Req,
            Map<String, Object> mapAnds4Det, Map<String, List> mapOrs4Det,String strId,String strUserNome,String strDbName) {
        this.strPdfName = strPdfName;
        this.strResumo = strResumo;
        this.strTipoDePdf = strTipoDePdf;
        this.dfStartQuery = dfStartQuery;
        this.dtEndQuery = dtEndQuery;
        this.mapAnds4Req = mapAnds4Req;
        this.mapOrs4Req = mapOrs4Req;
        this.mapAnds4Det = mapAnds4Det;
        this.mapOrs4Det = mapOrs4Det;
        this.strId = strId;
        this.strUserNome = strUserNome;
        this.strDateFieldName = strDateFieldName;
        this.strDbName = strDbName;
    }

    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName;
    }
    
    
    

    public String getStrOrdemDoRel() {
        return strOrdemDoRel;
    }

    public void setStrOrdemDoRel(String strOrdemDoRel) {
        this.strOrdemDoRel = strOrdemDoRel;
    }

    
    public String getStrDateFieldName() {
        return strDateFieldName;
    }

    public void setStrDateFieldName(String strDateFieldName) {
        this.strDateFieldName = strDateFieldName;
    }

    public String getStrTipoRelatorio() {
        return strTipoRelatorio;
    }

    public void setStrTipoRelatorio(String strTipoRelatorio) {
        this.strTipoRelatorio = strTipoRelatorio;
    }

    

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    public String getStrUserNome() {
        return strUserNome;
    }

    public void setStrUserNome(String strUserNome) {
        this.strUserNome = strUserNome;
    }

    
    
    public Date getDfStartQuery() {
        return dfStartQuery;
    }

    public void setDfStartQuery(Date dfStartQuery) {
        this.dfStartQuery = dfStartQuery;
    }

    public Date getDtEndQuery() {
        return dtEndQuery;
    }

    public void setDtEndQuery(Date dtEndQuery) {
        this.dtEndQuery = dtEndQuery;
    }

    public Map<String, Object> getMapAnds4Det() {
        return mapAnds4Det;
    }

    public void setMapAnds4Det(Map<String, Object> mapAnds4Det) {
        this.mapAnds4Det = mapAnds4Det;
    }

    public Map<String, Object> getMapAnds4Req() {
        return mapAnds4Req;
    }

    public void setMapAnds4Req(Map<String, Object> mapAnds4Req) {
        this.mapAnds4Req = mapAnds4Req;
    }

    public Map<String, List> getMapOrs4Det() {
        return mapOrs4Det;
    }

    public void setMapOrs4Det(Map<String, List> mapOrs4Det) {
        this.mapOrs4Det = mapOrs4Det;
    }

    public Map<String, List> getMapOrs4Req() {
        return mapOrs4Req;
    }

    public void setMapOrs4Req(Map<String, List> mapOrs4Req) {
        this.mapOrs4Req = mapOrs4Req;
    }

    public String getStrPdfName() {
        return strPdfName;
    }

    public void setStrPdfName(String strPdfName) {
        this.strPdfName = strPdfName;
    }

    public String getStrResumo() {
        return strResumo;
    }

    public void setStrResumo(String strResumo) {
        this.strResumo = strResumo;
    }

    public String getStrTipoDePdf() {
        return strTipoDePdf;
    }

    public void setStrTipoDePdf(String strTipoDePdf) {
        this.strTipoDePdf = strTipoDePdf;
    }
    

    @Override
    public String toString() {
        return "PdfDados{" + "strId=" + strId + ", strUserNome=" + strUserNome + ", strDateFieldName=" + strDateFieldName + ", strPdfName=" + strPdfName + ", dfStartQuery=" + dfStartQuery + ", dtEndQuery=" + dtEndQuery + ", mapAnds4Req=" + mapAnds4Req + ", mapOrs4Req=" + mapOrs4Req + ", mapAnds4Det=" + mapAnds4Det + ", mapOrs4Det=" + mapOrs4Det + '}';
    }



    
}
