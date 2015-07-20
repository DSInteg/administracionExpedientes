package administraScan;


import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eli
 */
public class SubsistemaListModel extends AbstractListModel{
 
    private ArrayList<SubSistema> lista = new ArrayList<>();
 
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        SubSistema s = lista.get(index);
        return s.getNombreSubSistema();
    }
    
    public void addSubsistema(SubSistema s){
        lista.add(s);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    
    public void limpiar(){
        lista.clear();
    }
 
    public SubSistema getSubsistema(int index){
        return lista.get(index);
    }
  
    
}    


