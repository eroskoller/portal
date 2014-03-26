
package br.com.portal.beans.login;

import java.io.Serializable;

/**
 *
 * @author eros
 */
public class IFramePage implements Serializable{

    
    
    private String id;
    
    
    private String title;
    private String titleResumido;
    private int tabIndex = 0;
    private String tabId;
    private String tabToolTip;
    private String tabInfoXml;
    
    
    private boolean blCloseble = true;
    private boolean blNative = false;
    
    
    private String modStCodigo;
    private String url;
    private boolean blAjax = false;
    private String iconCss;
    
    
    private String beanName;
    
    private Integer rating;
    
    
    public IFramePage() {
        super();
    }

    public IFramePage(String url, int index) {
        super();
        this.url = url;
        this.tabIndex = index;
    }
    
    

    public IFramePage(String title,String titleResumido,String url, int index,String tabId, String tabToolTip, String tabInfoXml,boolean blCloseble,boolean blNative,String id) {
        this.url = url;
        this.tabIndex = index;
        this.tabId = tabId;
        this.tabToolTip = tabToolTip;
        this.tabInfoXml = tabInfoXml;
        this.blCloseble = blCloseble;
        this.blNative = blNative;
        this.title = title;
        this.id = id;
        this.titleResumido = titleResumido;
    }

    public IFramePage(String modStCodigo, String url, String iconCss, String beanName,boolean  blAjax,boolean  blNative) {
        this.modStCodigo = modStCodigo;
        this.url = url;
        this.iconCss = iconCss;
        this.beanName = beanName;
        this.blAjax = blAjax;
        this.blNative = blNative;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        System.out.println("Rating: "+rating);
        this.rating = rating;
    }

    
    public String getModStCodigo() {
        return modStCodigo;
    }

    public void setModStCodigo(String modStCodigo) {
        this.modStCodigo = modStCodigo;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getIconCss() {
        return iconCss;
    }

    public void setIconCss(String iconCss) {
        this.iconCss = iconCss;
    }

    public boolean isBlAjax() {
        return blAjax;
    }

    public void setBlAjax(boolean blAjax) {
        this.blAjax = blAjax;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public boolean isBlNative() {
        return blNative;
    }

    public void setBlNative(boolean blNative) {
        this.blNative = blNative;
    }
    

    
    public boolean isBlCloseble() {
        return blCloseble;
    }

    public void setBlCloseble(boolean blCloseble) {
        this.blCloseble = blCloseble;
    }

    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getTabInfoXml() {
        return tabInfoXml;
    }

    public void setTabInfoXml(String tabInfoXml) {
        this.tabInfoXml = tabInfoXml;
    }

    public String getTabToolTip() {
        return tabToolTip;
    }

    public void setTabToolTip(String tabToolTip) {
        this.tabToolTip = tabToolTip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleResumido() {
        return titleResumido;
    }

    public void setTitleResumido(String titleResumido) {
        this.titleResumido = titleResumido;
    }
    
    
}
