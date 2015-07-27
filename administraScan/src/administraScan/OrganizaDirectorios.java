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
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

/**
 *
 * @author enriquedg
 */
public class OrganizaDirectorios {
    private Configuracion conf = new Configuracion();
    private Connection connection;
    public boolean resultado=true;
    
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
     public int retornaSize(){
        
        int retorno=100;
        String ruta = conf.carpetaRemota+"aceptados\\";
        File f = new File(ruta);    
        ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list()));
        System.out.println(names.size());
        retorno = names.size(); 
        System.out.println(names.size());
        if(!names.isEmpty())
        {
            System.out.println("Ya no hay nada");
        }
        
        return retorno;
    }
     
    public void clasificarCAS(){
    String rutaCAS;
    rutaCAS = conf.carpetaCAS+"\\";
    File f = new File(rutaCAS);
    FileUtils Archivos = new FileUtils();
    String curpct ="";
    System.out.println("Archivo Leido en memoria:"+f.list());
    
    ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list()));
        System.out.println(""+names);
        if (!names.isEmpty())
        {
            for (int i=0;i<names.size();i++)
            {
                System.out.println("Voy en :"+names.get(i));
                String curp= (names.get(i).substring(0, 18));
                System.out.println("Curp cortado"+curp);
                curpct = obtenerCT(curp);
                if(curp.equals(""))
                    
                        {
                            System.out.println("Ya no hay Constancias que mover");
                        }
                else{
                    System.out.println(""+curpct);
                    String RutaOr = (conf.carpetaCAS+names.get(i).toString());
                    String RutaDest = (conf.carpetaCT+curpct+"\\"+curp+"\\");
                    System.out.println(""+RutaOr);
                    System.out.println(""+RutaDest);
                    
                    File origen= new File(RutaOr);
                    File destino=new  File(RutaDest);
                    try {
                            Archivos.moveFileToDirectory(origen, destino, resultado);
                        //Aquí se actualiza la variable
                         
                    } catch(IOException E) {
                        E.printStackTrace();
                    }
                }    
            }   
        }
    }
    
    public boolean clasificar(){        
        String ruta = conf.carpetaRemota+"aceptados\\";
        File f = new File(ruta);    
        FileUtils Files = new FileUtils();
        String ct = "";
        System.out.println(f.list());
        ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list()));
        if(!names.isEmpty())
        {
            for (int i=0; i<names.size();i++) {
                System.out.println(names.get(i));
                System.out.println("hay algo");
                ct = obtenerCT(names.get(i));
                if(ct.equals("")){
                    System.out.println("Se acabó");

                }
                else
                {
                    String prueba = (String)(names.get(i).toString());
                    System.out.println(""+prueba);
                    String rutadestino = conf.carpetaCT + "\\" + names.get(i) + "\\";
                    File destino = new File(conf.carpetaCT + ct + "\\" /*+ names.get(i) + "/"*/);
                    File origen = new File(ruta+names.get(i)+"\\");
                    try {
                        Files.moveDirectoryToDirectory(origen, destino,true);
                        //Aquí se actualiza la variable
                         
                    } catch(IOException E) {
                        E.printStackTrace();
                    }
                }
            }
            resultado=false;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No ningun elemento que mover");
        }
            return resultado;
    }
    
    public void copiarCompletos() throws IOException
    {
        FileUtils Files = new FileUtils();
        AdministraScan adm = new AdministraScan();
        File origen;
        File destino;
        File f = new File(conf.carpetaCT);
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
        for(String ct : cts){
            String dirCT = conf.carpetaCT + ct.trim();
            File dir_expedientes = new File(dirCT);
            ArrayList<String> curps = new ArrayList<>(Arrays.asList(dir_expedientes.list()));
            for(String curp : curps){
                String dircurp = dirCT + "\\" + curp.trim();
                File doc = new File(dircurp);
                ArrayList<String> documentos = new ArrayList<>(Arrays.asList(doc.list()));
                ArrayList<String> claves = adm.RetornaCT(documentos);
                ArrayList<String> temporal = new ArrayList<>();
                for(String clave: claves){
                    if (!clave.equals("CAS")){
                        if(conf.OBLIGATORIOS.contains(clave)){
                            temporal.add(clave);
                        }
                    }
                }
                if(temporal.size() == conf.OBLIGATORIOS.size()-1){
                    String clave = "";
                    String nombre_ss="";
                    clave = ct.substring(3, 5);
                    this.conectarbd();
                    String consultaDescripcionSS="Select descripcion from cg_nivel_educativo where nivel_educativo = ?";
                    try {
                        PreparedStatement SPreparada;
                        SPreparada= connection.prepareStatement(consultaDescripcionSS);
                        SPreparada.setString(1,clave);
                        ResultSet resultadoDescripcion=SPreparada.executeQuery();
                        if(resultadoDescripcion.next()){
                            nombre_ss=resultadoDescripcion.getString("descripcion").trim();
                        }            
                    SPreparada.close();
                    connection.close(); 


                    } catch (SQLException ex) {
                        Logger.getLogger(SubSistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String ruta_destino = conf.carpetaRemota + "completos\\" + nombre_ss + "\\" + ct.trim();
                    origen = new File(dircurp);
                    destino = new File(ruta_destino);
                    Files.copyDirectoryToDirectory(doc, destino);
                }
            }
        }
    }
    
    public void uniendopdfs(String ruta, String documento1, String documento2){
        PDFMergerUtility ut = new PDFMergerUtility();
        File d1 = new File(ruta+documento1);
        File d2 = new File(ruta+documento2);
        if(d1.exists() && d2.exists()){
            System.out.println("Uniendo archivos: "+documento1+"-->"+documento2);
            ut.addSource(ruta+documento1);
            ut.addSource(ruta+documento2);
            ut.setDestinationFileName(ruta+documento1);
            try {
                ut.mergeDocuments();
                System.out.println("Exito");
                File temp=new File(ruta+documento2);
                System.out.println("Borrar: "+ruta+documento2);
                temp.delete();
            } catch (IOException ex) {
                System.out.println("Error fatal");
                ex.printStackTrace();
                Logger.getLogger(OrganizaDirectorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (COSVisitorException ex) {
                System.out.println("Error Libreria");
                ex.printStackTrace();
                Logger.getLogger(OrganizaDirectorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void unirpdfs()
    {
        ArrayList<String> docs = new ArrayList<>(Arrays.asList(conf.CLAVES_DOC));
        docs.add("PRI");
        docs.add("SEC");
        docs.add("PRE");
        docs.add("LIC");
        docs.add("MAE");
        docs.add("DOC");
        AdministraScan adm = new AdministraScan();
        String ruta ="";
        File f = new File(conf.carpetaCT);
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
        for(String ct : cts){
            String dirCT = conf.carpetaCT + ct.trim();
            File dir_expedientes = new File(dirCT);
            ArrayList<String> curps = new ArrayList<>(Arrays.asList(dir_expedientes.list()));
            for(String curp : curps){
                String dircurp = dirCT + "\\" + curp.trim();
                System.out.println("Revisando carpeta: "+dirCT);
                File doc = new File(dircurp);
                ArrayList<String> documentos = new ArrayList<>(Arrays.asList(doc.list()));
                for(String documento:documentos){
                    System.out.println("Verificando archivo: "+documento);
                    String[] aux;
                    String nombre="";
                    String clave="";
                    String pre="";
                    String pos="";
                    aux = documento.split("\\.");
                    nombre = aux[0];
                    aux = nombre.split("_");
                    if(aux.length==3){
                        for(int n=0;n<2;n++){
                            if(n==0)
                                clave = aux[1];
                            else
                                clave = aux[2];
                            ArrayList<String> claves = new ArrayList<>();
                            claves.add(clave);
                            for(int i=1;i<10;i++){
                                claves.add(clave+i);
                            }
                            for(int i=0;i<5;i++){
                                if(i==0){
                                    pre = documento.replace(clave, claves.get(0));
                                    pos = documento.replace(clave, claves.get(1));
                                }
                                if(i==1){
                                    pre = documento.replace(clave, claves.get(2));
                                    pos = documento.replace(clave, claves.get(3));
                                }
                                if(i==2){
                                    pre = documento.replace(clave, claves.get(4));
                                    pos = documento.replace(clave, claves.get(5));
                                }
                                if(i==3){
                                    pre = documento.replace(clave, claves.get(6));
                                    pos = documento.replace(clave, claves.get(7));
                                }
                                if(i==4){
                                    pre = documento.replace(clave, claves.get(8));
                                    pos = documento.replace(clave, claves.get(9));
                                }
                                this.uniendopdfs(dircurp+"\\", pre, pos);
                            }
                        }
                    }
                    else{
                        clave = aux[1];
                        ArrayList<String> claves = new ArrayList<>();
                        claves.add(clave);
                        for(int i=1;i<10;i++){
                            claves.add(clave+i);
                        }
                        for(int i=0;i<5;i++){
                            if(i==0){
                                pre = documento.replace(clave, claves.get(0));
                                pos = documento.replace(clave, claves.get(1));
                            }
                            if(i==1){
                                pre = documento.replace(clave, claves.get(2));
                                pos = documento.replace(clave, claves.get(3));
                            }
                            if(i==2){
                                pre = documento.replace(clave, claves.get(4));
                                pos = documento.replace(clave, claves.get(5));
                            }
                            if(i==3){
                                pre = documento.replace(clave, claves.get(6));
                                pos = documento.replace(clave, claves.get(7));
                            }
                            if(i==4){
                                pre = documento.replace(clave, claves.get(8));
                                pos = documento.replace(clave, claves.get(9));
                            }
                            this.uniendopdfs(dircurp+"\\", pre, pos);
                        }
                    }
                }
            }
        }
    }
}
