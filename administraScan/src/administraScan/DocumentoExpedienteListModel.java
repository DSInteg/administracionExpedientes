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
public class DocumentoExpedienteListModel extends AbstractListModel{
    private ArrayList<DocumentoExpediente> lista = new ArrayList<>();
 
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        DocumentoExpediente de = lista.get(index);
        return de.getNombre() + "*" + de.getEscaneado();
    }
    
    public void addDocumentoExpediente(DocumentoExpediente de){
        lista.add(de);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    
    public void limpiar(){
        lista.clear();
    }
    
    public DocumentoExpediente getDocumento(int index){
        return lista.get(index);
    }
  
    
}
