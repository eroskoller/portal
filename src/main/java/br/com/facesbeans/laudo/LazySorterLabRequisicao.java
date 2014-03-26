/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.hibernate.entities.LabRequisicao;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author eros
 */
public class LazySorterLabRequisicao implements Comparator<LabRequisicao> {

    private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorterLabRequisicao(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(LabRequisicao lr1, LabRequisicao lr2) {
        try {
            Object value1 = LabRequisicao.class.getField(this.sortField).get(lr1);
            Object value2 = LabRequisicao.class.getField(this.sortField).get(lr2);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}

