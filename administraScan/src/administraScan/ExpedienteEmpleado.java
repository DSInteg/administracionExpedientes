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
    private String Clave;
    private ArrayList<DocumentoExpediente> Documentacion;
    
    public ExpedienteEmpleado(ArrayList<DocumentoExpediente> documentos, String clave)
    {
        this.Documentacion = documentos;
        this.Clave = clave;
    }
    
    public ArrayList<DocumentoExpediente> getDocumentacion()
    {
        return this.Documentacion;
    }
    
    public String getClave()
    {
        return this.Clave;
    }
    
    public ArrayList<DocumentoExpediente> getObligatorios()
    {
        Configuracion conf = new Configuracion();
        ArrayList<DocumentoExpediente> obligatorios = new ArrayList<>();
        ArrayList<DocumentoExpediente> documentos = this.getDocumentacion();
        for(DocumentoExpediente documento : documentos)
        {
            if(conf.OBLIGATORIOS.contains(documento.getClave()))
            {
                obligatorios.add(documento);
            }
        }
        return obligatorios;
    }
    
    public ArrayList<DocumentoExpediente> getOpcionales()
    {
        Configuracion conf = new Configuracion();
        ArrayList<DocumentoExpediente> opcionales = new ArrayList<>();
        ArrayList<DocumentoExpediente> documentos = this.getDocumentacion();
        for(DocumentoExpediente documento : documentos)
        {
            if(!conf.OBLIGATORIOS.contains(documento.getClave()))
            {
                opcionales.add(documento);
            }
        }
        return opcionales;
    }
}
