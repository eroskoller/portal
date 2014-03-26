/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.monitor.faturamento;

import java.io.Serializable;

/**
 *
 * @author eros
 */
public class MonitorDados implements Serializable{
    
    private int intChoice = 0;
    private String[] aXisLabelCustom = null;
    
    private double[][] dataPacientes = null;
    private double[][] dataExames = null;
    private double[][] dataValor = null;

    public MonitorDados(int intChoice,String[] aXisLabelCustom, double[][] dataPacientes, double[][] dataExames, double[][] dataValor ) {
        this.intChoice = intChoice;
        this.aXisLabelCustom = aXisLabelCustom;
        this.dataPacientes = dataPacientes;
        this.dataExames = dataExames;
        this.dataValor = dataValor;
    }

    

    public String[] getaXisLabelCustom() {
        return aXisLabelCustom;
    }

    public void setaXisLabelCustom(String[] aXisLabelCustom) {
        this.aXisLabelCustom = aXisLabelCustom;
    }

    public double[][] getDataExames() {
        return dataExames;
    }

    public void setDataExames(double[][] dataExames) {
        this.dataExames = dataExames;
    }

    public double[][] getDataPacientes() {
        return dataPacientes;
    }

    public void setDataPacientes(double[][] dataPacientes) {
        this.dataPacientes = dataPacientes;
    }

    public double[][] getDataValor() {
        return dataValor;
    }

    public void setDataValor(double[][] dataValor) {
        this.dataValor = dataValor;
    }

    public int getIntChoice() {
        return intChoice;
    }

    public void setIntChoice(int intChoice) {
        this.intChoice = intChoice;
    }
    
    
    
}
