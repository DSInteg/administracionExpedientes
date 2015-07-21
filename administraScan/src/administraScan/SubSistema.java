package administraScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public SubSistema(String clave)
    {
        this.claveSubSistema = clave;
        this.getDatosSubsistema(clave);
        this.CentrosTrabajoSubsistema = new ArrayList<>();
    }
    
    private void getDatosSubsistema(String clave){
        String Id = "";
        this.conectarbd();
        String consultaDescripcionSS="Select descripcion from cg_nivel_educativo where nivel_educativo = ?";
        System.out.println(consultaDescripcionSS);
        try {
            PreparedStatement SPreparada;
            SPreparada= connection.prepareStatement(consultaDescripcionSS);
            SPreparada.setString(1,clave);
            ResultSet resultadoDescripcion=SPreparada.executeQuery();
            if(resultadoDescripcion.next()){
                Id=resultadoDescripcion.getString("descripcion").trim();
                System.out.println(clave);
                System.out.println(Id);
            }            
        SPreparada.close();
        connection.close(); 
           
            
        } catch (SQLException ex) {
            Logger.getLogger(SubSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nombreSubSistema = Id;
    }
        
    public String getClaveSubSistema(){
        return this.claveSubSistema;
    }
    
    public void setClaveSubSistema(String clave){
        this.claveSubSistema = clave;
    }
    
    public String getNombreSubSistema(){
        return this.nombreSubSistema;
    }
    
    public void setNombreSubSistema(String nombre){
        this.nombreSubSistema = nombre;
    }
    
    //regresa todos los CT dentro de un Subsistema
    public ArrayList<CentroTrabajo> getCTSubSistema(String SubSistema){
        return null;
        
    }
    
    public void setCTSubsistema(CentroTrabajo CT)
    {
        this.CentrosTrabajoSubsistema.add(CT);
    }
    
    public ArrayList<CentroTrabajo> getCentrosTrabajoSubsistema()
    {
        return this.CentrosTrabajoSubsistema;
    }
}
