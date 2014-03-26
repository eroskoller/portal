/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eros
 */
public class IFrameHolder implements Serializable{
    
    private Map<String,IFramePage>  mapIFramePages = new HashMap<String, IFramePage>();

    public Map<String, IFramePage> getMapIFramePages() {
        return mapIFramePages;
    }

    public void setMapIFramePages(Map<String, IFramePage> mapIFramePages) {
        this.mapIFramePages = mapIFramePages;
    }

    @Override
    public String toString() {
        return "IFrameHolder{" + "mapIFramePages=" + mapIFramePages + '}';
    }

    
    
    
}
