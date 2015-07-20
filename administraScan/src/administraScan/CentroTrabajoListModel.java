/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Eli
 */
public class CentroTrabajoListModel extends AbstractListModel {
     private ArrayList<CentroTrabajo> lista = new ArrayList<>();
 
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        CentroTrabajo ct = lista.get(index);
        return ct.getClaveCT();
    }
    
    public void addCentroTrabajo(CentroTrabajo ct){
        lista.add(ct);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    
    public void limpiar(){
        lista.clear();
    }
    
    public CentroTrabajo getCentroTrabajo(int index){
        return lista.get(index);
    }
  
    
}
