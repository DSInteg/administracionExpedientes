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
    
    public DocumentoExpediente(String clave, Boolean escaneado)
    {
        Configuracion conf = new Configuracion();
        this.Clave = clave;
        if (conf.OBLIGATORIOS.contains(clave))
        {
            this.Obligatorio = true;
        }
        else
        {
            this.Obligatorio = false;
        }
        this.Escaneado = escaneado;
        
    }
    
    public String getClave()
    {
        return this.Clave;
    }
    
    public Boolean getObligatorio()
    {
        return this.Obligatorio;
    }
    
    public Boolean getEscaneado()
    {
        return this.Escaneado;
    }
}
