/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.facesbeans.cadastro;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eros
 */

@SessionScoped
@ManagedBean(name="cadastroPacView")
public class CadastroPacView implements Serializable{
    
    private String strPacNome;

    public String getStrPacNome() {
        return strPacNome;
    }

    public void setStrPacNome(String strPacNome) {
        this.strPacNome = strPacNome;
    }
    
    
    
    
}
