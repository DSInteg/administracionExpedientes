/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

/**
 *
 * @author Juan
 */
public class Empleado {
    private String Nombre;
    private String Paterno;
    private String Materno;
    private String CURP;
    private ExpedienteEmpleado Expediente;
    private CentroTrabajo  CTEmpleado;
    
    public Empleado(String curp)
    {
        this.CURP = curp;
    }
    
    public String getCURP()
    {
        return this.CURP;
    }
    
    public ExpedienteEmpleado getExpediente()
    {
        return this.Expediente;
    }
    
    public CentroTrabajo getCTEmpleado()
    {
        return this.CTEmpleado;
    }
    
    public void setExpediente(ExpedienteEmpleado expediente)
    {
        this.Expediente = expediente;
    }
}
