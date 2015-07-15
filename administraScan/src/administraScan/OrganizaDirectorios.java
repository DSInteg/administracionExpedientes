/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author enriquedg
 */
public class OrganizaDirectorios {
    private Configuracion conf = new Configuracion();
    private Connection connection;
    
    public OrganizaDirectorios(){}
    
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
    
    public String obtenerCT(String curp){
        this.conectarbd();
        String consulta="Select ct from curp_rfc where curp =?";
        System.out.println(consulta);
        String ct="";       
        try {
            PreparedStatement preparado;
            preparado = connection.prepareStatement(consulta);
            preparado.setString(1,curp);
            ResultSet resultado=preparado.executeQuery();
            if(resultado.next()){
                ct=resultado.getString("ct");
                System.out.println("CT :D : "+ct);
            }
            preparado.close();
            connection.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(OrganizaDirectorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct.trim();
    }
    
    public void clasificar(){        
        String ruta = conf.carpetaRemota+"aceptados\\";
        File f = new File(ruta);    
        FileUtils Files = new FileUtils();
        String ct = "";
        System.out.println(f.list());
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
        if(!names.isEmpty())
        {
            for (int i=0; i<names.size();i++) {
                System.out.println(names.get(i));
                ct = obtenerCT(names.get(i));
                if(ct.equals("")){
                    System.out.println("Se acabó");
                }
                else
                {
                    String prueba = (String)(names.get(i).toString());
                    String rutadestino = conf.carpetaCT + "\\" + names.get(i) + "\\";
                    //System.out.println("CT:"+ct);
                    //System.out.println(rutadestino);
                    File destino = new File(conf.carpetaCT + ct + "\\" /*+ names.get(i) + "\\"*/);
                    File origen = new File(ruta+names.get(i)+"\\");   
                    try {
                        //System.out.println(origen);
                        //System.out.println(destino);
                        Files.moveDirectoryToDirectory(origen, destino,true);
                    } catch(IOException E) {
                        //System.out.println("No se pudo copiar el archivo");
                        E.printStackTrace();
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Se han movido exitosamente los elementos de directorio");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No ningun elemento que mover");
        }
    }
}
