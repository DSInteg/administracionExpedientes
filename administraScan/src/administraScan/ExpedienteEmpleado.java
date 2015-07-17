/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class ExpedienteEmpleado {
    private ArrayList<DocumentoExpediente> Documentacion;
    
    public ExpedienteEmpleado(ArrayList<DocumentoExpediente> documentos)
    {
        this.Documentacion = documentos;
    }
    
    public ArrayList<DocumentoExpediente> getDocumentacion()
    {
        return this.Documentacion;
    }
    
}
