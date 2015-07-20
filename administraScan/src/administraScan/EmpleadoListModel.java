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
public class EmpleadoListModel extends AbstractListModel{
 private ArrayList<Empleado> lista = new ArrayList<>();
 
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        Empleado e = lista.get(index);
        return e.getNombreCompleto();
    }
    
    public void addEmpleado(Empleado e){
        lista.add(e);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    
    public void limpiar(){
        lista.clear();
    }
    
    public Empleado getEmpleado(int index){
        return lista.get(index);
    }
  
    
}
