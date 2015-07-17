/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    private Configuracion conf = new Configuracion();
    private Connection connection;
    
    public void conectarbd()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(conf.DATABASE_URL, conf.USUARIO, conf.PASSWORD);
            System.out.println("Conectado");
        }
        catch (ClassNotFoundException | SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
       
    
    public Empleado(String curp)
    {
        this.CURP = curp;
        //HashMap<String, String> datos = this.obtenerDatosEmpleado(curp);
        this.obtenerDatosEmpleado(curp);
    }
    
    
    
    public String getCURP()
    {
        return this.CURP;
    }
    
     public void obtenerDatosEmpleado(String curp){
        this.conectarbd();
        String consultaDatos="Select nombre, paterno, materno, ct from curp_rfc where curp =?";
        System.out.println(consultaDatos);
        //String Nombre="";
            
            
           
     try {
          PreparedStatement SPreparada;
         SPreparada= connection.prepareStatement(consultaDatos);
         SPreparada.setString(1,curp);
            ResultSet resultadoDatosEmpleado=SPreparada.executeQuery();
              if(resultadoDatosEmpleado.next()){
                Nombre=resultadoDatosEmpleado.getString("nombre").trim();
                Paterno=resultadoDatosEmpleado.getString("paterno".trim());
                Materno=resultadoDatosEmpleado.getString("materno").trim();
                CentroTrabajo ct = new CentroTrabajo(resultadoDatosEmpleado.getString("ct").trim());
                CTEmpleado=ct;

               System.out.println("Nombre"+Nombre+Paterno+Materno);
            }
                        
            SPreparada.close();
            connection.close(); 
           
            
     } catch (SQLException ex) {
         Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
         
     }
            
            
          
    }
    
    
}
