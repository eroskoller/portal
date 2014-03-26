/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.hibernate.entities.LabRequisicao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author eros
 */
public class LabRequisicaoDataModelLazy 
    extends LazyDataModel<LabRequisicao>   implements Serializable{
    
       private List<LabRequisicao> datasource;  
       
        public LabRequisicaoDataModelLazy(List<LabRequisicao> datasource) {  
            this.datasource = datasource;  
        }  
        
         @Override  
         public LabRequisicao getRowData(String rowKey) {  
                for(LabRequisicao lr : datasource) {  
                    if(lr.getReqStCodigo().equals(rowKey))  
                        return lr;  
                }  
                return null;  
            }  
    @Override  
    public Object getRowKey(LabRequisicao lr) {  
        return lr.getReqStCodigo();
    }  

    
    @Override  
    public List<LabRequisicao> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {  
        List<LabRequisicao> data = new ArrayList<LabRequisicao>();  
  
        //filter  
        for(LabRequisicao lr : datasource) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    String filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(lr.getClass().getField(filterProperty).get(lr));  
  
                    if(filterValue == null || fieldValue.startsWith(filterValue)) {  
                        match = true;  
                    }  
                    else {  
                        match = false;  
                        break;  
                    }  
                } catch(Exception e) {  
                    match = false;  
                }   
            }  
  
            if(match) {  
                data.add(lr);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new LazySorterLabRequisicao(sortField, sortOrder));  
        }  
  
        //rowCount  
        int dataSize = data.size();  
        this.setRowCount(dataSize);  
  
        //paginate  
        if(dataSize > pageSize) {  
            try {  
                return data.subList(first, first + pageSize);  
            }  
            catch(IndexOutOfBoundsException e) {  
                return data.subList(first, first + (dataSize % pageSize));  
            }  
        }  
        else {  
            return data;  
        }  
    }  
    
    
}
