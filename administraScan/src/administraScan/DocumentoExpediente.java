/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

/**
 *
 * @author Juan
 */
public class DocumentoExpediente {
    private String Nombre;
    private String Tipo;
    private Boolean Obligatorio;
    private Boolean Escaneado;
    private String Direccion;
    private String Clave;
    
    public DocumentoExpediente(String clave)
    {
        this.Clave = clave;
    }
    public String getClave()
    {
        return this.Clave;
    }
}
