package administraScan;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan
 */
public class SubSistema {
    private String  claveSubSistema;
    private String  nombreSubSistema;
    private ArrayList<CentroTrabajo> CentrosTrabajoSubsistema;
    
    public SubSistema(String clave)
    {
        this.claveSubSistema = clave;
    }
    
    public String getClaveSubSistema(){
        return this.claveSubSistema;
    }
    
    public void setClaveSubSistema(String clave){
        this.claveSubSistema = clave;
    }
     
    public void getNombreSubSistema(String nombre){
        this.nombreSubSistema = nombre;
    }
    
    public String setNombreSubSistema(){
        return this.nombreSubSistema;
    }
    
    //regresa todos los CT dentro de un Subsistema
    public ArrayList<CentroTrabajo> getCTSubSistema(String SubSistema){
        return null;
        
    }
    
}
