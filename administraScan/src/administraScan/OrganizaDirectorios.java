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
                        //System.out.println(origen);
                        //System.out.println(destino);
                            Archivos.moveFileToDirectory(origen, destino, resultado);
                        //Aquí se actualiza la variable
                         
                    } catch(IOException E) {
                        //System.out.println("No se pudo copiar el archivo");
                        
                        E.printStackTrace();
                    }
                }    
            }   
        }
    }
    
    public boolean clasificar(){        
        //String ruta = conf.carpetaRemota+"aceptados\\";
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
                    //String rutadestino = conf.carpetaCT + "\\" + names.get(i) + "\\";
                    String rutadestino = conf.carpetaCT + "\\" + names.get(i) + "\\";
                    //System.out.println("CT:"+ct);
                    //System.out.println(rutadestino);
                    //File destino = new File(conf.carpetaCT + ct + "\\" /*+ names.get(i) + "\\"*/);
                    File destino = new File(conf.carpetaCT + ct + "\\" /*+ names.get(i) + "\\"*/);
                    //File origen = new File(ruta+names.get(i)+"\\");
                    File origen = new File(ruta+names.get(i)+"\\");
                    try {
                        //System.out.println(origen);
                        //System.out.println(destino);
                        Files.moveDirectoryToDirectory(origen, destino,true);
                        //Aquí se actualiza la variable
                         
                    } catch(IOException E) {
                        //System.out.println("No se pudo copiar el archivo");
                        
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
                    //System.out.println(consultaDescripcionSS);
                    try {
                        PreparedStatement SPreparada;
                        SPreparada= connection.prepareStatement(consultaDescripcionSS);
                        SPreparada.setString(1,clave);
                        ResultSet resultadoDescripcion=SPreparada.executeQuery();
                        if(resultadoDescripcion.next()){
                            nombre_ss=resultadoDescripcion.getString("descripcion").trim();
                            //System.out.println(clave);
                            //System.out.println(Id);
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
    
    public void unirpdfs()
    {
        ArrayList<String> docs = new ArrayList<>(Arrays.asList(conf.CLAVES_DOC));
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
                File doc = new File(dircurp);
                ArrayList<String> documentos = new ArrayList<>(Arrays.asList(doc.list()));
                ArrayList<String> doc_obli = new ArrayList<>();
                ArrayList<String> temporal = new ArrayList<>();
                String[] array_numeros = {"1","2","3","4","5","6","7"};
                ArrayList<String> numeros = new ArrayList<>(Arrays.asList(array_numeros));
                for(String documento :documentos){
                    String [] parts_doc = documento.split("\\.");
                    parts_doc = parts_doc[0].split("_");
                    String num = parts_doc[parts_doc.length-1];
                    if(numeros.contains(num))
                        temporal.add(documento);
                }
                int num = 1;
                int aux = 0;
                for(int i=0;i<4;i++ ){
                    String pre="";
                    String pos="";
                    for(String obli:docs){
                        if(i==0){
                            pre = obli;
                            pos = obli + "_1";
                        }
                        if(i==1){
                            pre = obli+ "_2";
                            pos = obli + "_3";
                        }
                        if(i==2){
                            pre = obli+ "_4";
                            pos = obli + "_5";
                        }
                        if(i==3){
                            pre = obli+ "_6";
                            pos = obli + "_7";
                        }
                        String doc1="";
                        String doc2="";
                        for(String docu:temporal){
                            if(docu.contains(pre))
                                doc1 = docu;
                            if(docu.contains(pos))
                                doc2 = docu;
                        }
                        if(!doc1.equals("") && !doc2.equals("")){
                            ruta = dircurp + "\\";
                            PDFMergerUtility ut = new PDFMergerUtility();
                            ut.addSource(ruta+doc1);
                            ut.addSource(ruta+doc2);
                            ut.setDestinationFileName(ruta+doc1);
                            try {
                                ut.mergeDocuments();
                                System.out.println("Exito");
                                System.out.println(doc1 + "---" + doc2);
                                System.out.println(dircurp);
                                File temp=new File(ruta+doc2);
                                System.out.println("Borrar: "+ruta+doc2);
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
                }
            }
        }
    }
}
