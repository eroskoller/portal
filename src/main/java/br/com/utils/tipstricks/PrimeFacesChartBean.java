///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.utils.tipstricks;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.Serializable;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;
//import org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;
//import org.primefaces.model.chart.CartesianChartModel;
//import org.primefaces.model.chart.ChartSeries;
//
///**
// *
// * @author ricardo
// */
//@ManagedBean(name="chartBean")
//@ApplicationScoped
//public class PrimeFacesChartBean implements Serializable{
//    
//    private CartesianChartModel categoryModel;
//
//    public PrimeFacesChartBean() {
//        createCategoryModel();
//    }
//    
//    public CartesianChartModel getCategoryModel() {
//        if(categoryModel == null){
//            createCategoryModel();
//        }
//        return categoryModel;
//    }
//    
//    private void createCategoryModel() {
//        categoryModel = new CartesianChartModel();
//  
//        ChartSeries unidade1 = new ChartSeries();
//        unidade1.setLabel("Lab1");
//  
//        unidade1.set("2004", 2);
//        unidade1.set("2005", 4);
//        unidade1.set("2006", 8);
//        unidade1.set("2007", 16);
//        unidade1.set("2008", 32);
//        unidade1.set("2009", 64);
//        unidade1.set("2010", 128);
//        unidade1.set("2011", 256);
//        unidade1.set("2012", 512);
//        
//  
//        ChartSeries unidade2 = new ChartSeries();
//        unidade2.setLabel("Lab2");
//  
//        unidade2.set("2004", 52);
//        unidade2.set("2005", 60);
//        unidade2.set("2006", 110);
//        unidade2.set("2007", 135);
//        unidade2.set("2008", 120);
//        unidade2.set("2009", 200);
//        unidade2.set("2010", 120);
//        unidade2.set("2011", 140);
//        unidade2.set("2012", 180);
//  
//        categoryModel.addSeries(unidade1);
//        categoryModel.addSeries(unidade2);
//    }
//    
//}
