/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author eros
 */
@ManagedBean(name = "dateSelect")
@ViewScoped
public class SelectInputDateBean implements Serializable{
        /**
     * Variables to store the selected dates.
     */
    private Date date1=new Date();
    private Date date2=new Date();
    private Date date3=new Date();
    private Date date4=new Date();    
    private Date date5=new Date();
    private String pattern ="date";
    private List patterns = new ArrayList();
    // effect is fired when dat2 value is changed.  

    public SelectInputDateBean() {
        super();
        date2 = new GregorianCalendar().getTime();
        patterns.add(new SelectItem("date", "MM/dd/yyyy"));
        patterns.add(new SelectItem("dateTime", "MMM/dd/yyyy HH:mm"));
        patterns.add(new SelectItem("dateTimeSs", "MMM/dd/yyyy HH:mm:ss"));
        patterns.add(new SelectItem("dateTimeAmPm", "MMM/dd/yyyy hh:mm a"));
        
        patterns.add(new SelectItem("dateBR", "dd/MM/yyyy"));
        patterns.add(new SelectItem("dateTimeBR", "dd/MMM/yyyy HH:mm"));
        patterns.add(new SelectItem("dateTimeSsBR", "dd/MMM/yyyy HH:mm:ss"));
        patterns.add(new SelectItem("dateTimeAmPmBR", "dd/MMM/yyyy hh:mm a"));

        
    }

    /**
     * Gets the first selected date.
     *
     * @return the first selected date
     */
    public Date getDate1() {
        return date1;
    }

    /**
     * Sets the first selected date.
     *
     * @param date the first selected date
     */
    public void setDate1(Date date) {
        date1 = date;
    }

    /**
     * Gets the 2nd selected date.
     *
     * @return the 2nd selected date
     */
    public Date getDate2() {
        return date2;
    }

    /**
     * Sets the 2nd selected date.
     *
     * @param date the 2nd selected date
     */
    public void setDate2(Date date) {
        date2 = date;
    }

    /**
     * Gets the default timezone of the host server.  The timezone is needed
     * by the convertDateTime for formatting the time dat values.
     *
     * @return timezone for the current JVM
     */
    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    /**
     * When values change event occures on date2 then we reset the effect
     * so the user can see the changed value more easily.
     *
     * @param event JSF value change event. 
     */


    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public List getPatterns() {
        return patterns;
    }

    public void setPatterns(List patterns) {
        this.patterns = patterns;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    public Date getDate5() {
        return date5;
    }

    public void setDate5(Date date5) {
        this.date5 = date5;
    }
    

}
