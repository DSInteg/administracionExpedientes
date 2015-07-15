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
public class CentroTrabajo {
    private String  claveCT;
    private ArrayList<Empleado> PlantillaEmpleados;
    
    public CentroTrabajo(String claveCT){
        this.claveCT=claveCT;
        PlantillaEmpleados=obtenerPlantillaEmpleados();
        
    }
    private ArrayList<Empleado> obtenerPlantillaEmpleados(){
        ArrayList<Empleado> plantilla = new ArrayList<Empleado>();
        return plantilla;
    }
    
    public ArrayList<Empleado> getPantillaEmpleados(){
        
        return PlantillaEmpleados;
    }

}
