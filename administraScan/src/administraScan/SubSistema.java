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
    public String getNombreSubSistema(){
        return this.nombreSubSistema;
    }
    
    public void setClaveSubSistema(String clave){
        this.claveSubSistema = clave;
    }
    public void getNombreSubSistema(String nombre){
        this.nombreSubSistema = nombre;
    }
    
    //lee de la base de datos todos los subsistemas
    public ArrayList<SubSistema> getAllSubSistema(){
        
        return null;
        
    }
    //regresa todos los CT dentro de un Subsistema
    public ArrayList<CentroTrabajo> getCTSubSistema(String SubSistema){
        return null;
        
    }
    
}
