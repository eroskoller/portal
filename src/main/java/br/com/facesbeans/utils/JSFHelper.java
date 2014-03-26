package br.com.facesbeans.utils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
 
public class JSFHelper implements Serializable{
   
    public static ExternalContext getExternalContext(){
        FacesContext externalcontext = FacesContext.getCurrentInstance();
        return externalcontext.getExternalContext();
    }
   
    public static String getRequestParameter(String parameterName){
        Map paramMap = getExternalContext().getRequestParameterMap();
        return (String) paramMap.get(parameterName);
    }
 
    public static Object getRequestAttribute(String attributeName){
        Map attributeMap = getExternalContext().getRequestMap();
        return attributeMap.get(attributeName);
    }
   
    public static Object getSessionAttribute(String attributeName){
        Map attributeMap = getExternalContext().getSessionMap();
        return attributeMap.get(attributeName);
    }
   
    public static Object getApplicationAttribute(String attributeName){
        Map attributeMap = getExternalContext().getApplicationMap();
        return attributeMap.get(attributeName);
    }
   
}