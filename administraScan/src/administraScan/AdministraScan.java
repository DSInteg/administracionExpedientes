/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author enriquedg
 */
public class AdministraScan {
    private final Configuracion conf;
    HashMap<String, String> DOCUMENTOS;
    private Connection connection;
    
    public AdministraScan(){
        this.conf = new Configuracion();
        this.DOCUMENTOS = new HashMap();
        for(int i = 0; i<conf.CLAVES_DOC.length; i++)
        {
            this.DOCUMENTOS.put(conf.CLAVES_DOC[i], conf.NOMBRES_DOC[i]);
        }
    }
    
    public ArrayList<String> RetornaCT(ArrayList<String> nombres){
        ArrayList<String> claves = new ArrayList<>();
        String[] array_numeros = {"1","2","3","4","5","6","7"};
        ArrayList<String> numeros = new ArrayList<>(Arrays.asList(array_numeros));
        for(String nombre : nombres){
            String str="";
            StringBuffer cadena = new StringBuffer();
            String[] parts_doc = nombre.split("_");
            String [] extension_doc = parts_doc[parts_doc.length-1].split("\\.");
            String [] resultado = extension_doc[extension_doc.length-2].split("");
            if(!numeros.contains(extension_doc[extension_doc.length-2])){
                cadena = cadena.append(extension_doc[extension_doc.length-2]);
            }
            if(cadena.length()>0){
                str = cadena.toString();
                if(!claves.contains(str)){
                   claves.add(str);
                }   
            }
        }
        return claves;
    }
    //Eli
    
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
    //aqui le empecé a mover
    public ArrayList<SubSistema> getAllSubsistemas(){
      //  ArrayList IDSub <String>= new ArrayList
        ArrayList <SubSistema> subsistemas = new ArrayList<>(); 
        String Nivel_Educativo ="";
        ArrayList<String> IDSub=new ArrayList<>();
        this.conectarbd();
        String consultaSubsistemas="Select nivel_educativo from cg_nivel_educativo";
        System.out.println(consultaSubsistemas);
           
        try {
             PreparedStatement SPreparada;
            SPreparada= connection.prepareStatement(consultaSubsistemas);
            //SPreparada.setString(1,);
               ResultSet resultadoSubsistemas=SPreparada.executeQuery();

               if(resultadoSubsistemas.next()){
                   Nivel_Educativo=resultadoSubsistemas.getString("nivel_educativo").trim();
                   IDSub.add(Nivel_Educativo);
                   System.out.println("Subsistema");
               }

               SPreparada.close();
               connection.close(); 


        } catch (SQLException ex) {
            Logger.getLogger(AdministraScan.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        for (String id : IDSub )
        {
            SubSistema sub =new SubSistema(id);
            subsistemas.add(sub);
        }
            
        return  subsistemas;        
          
    }

    public ArrayList<SubSistema> getsubsistemas(ArrayList<String> cts)
    {
        ArrayList<String> keys_subsis = new ArrayList<>();
        ArrayList<SubSistema> subsistemas = new ArrayList<>();
        String clave = "";
        for (String ct : cts)
        {
            clave = ct.substring(3, 5);
            if (!keys_subsis.contains(clave))
            {
                keys_subsis.add(clave);
            }
        }
        for(String key : keys_subsis)
        {
            SubSistema subs = new SubSistema(key);
            subsistemas.add(subs);
        }
        return subsistemas;
    }
    
    public ArrayList<CentroTrabajo> getCTSfromSubsistema(SubSistema subsistema)
    {
        File f = new File(conf.carpetaCT); 
        ArrayList<String> list_cts = new ArrayList<>(Arrays.asList(f.list()));
        ArrayList<CentroTrabajo> cts = new ArrayList<>();
        for(String ct : list_cts)
        {
            String clave = ct.substring(3, 5);
            //System.out.println(clave);
            if(subsistema.getClaveSubSistema().equals(clave))
            {
                CentroTrabajo ct_obj = new CentroTrabajo(ct);
                subsistema.setCTSubsistema(ct_obj);
                cts.add(ct_obj);
            }
        }
        return cts;
    }
    
    public ArrayList<Empleado> getEmpleadosfromCT(CentroTrabajo ct)
    {
        String curp = "";
        ArrayList<Empleado> empleados = new ArrayList<>();
        this.conectarbd();
        String consultaDatos = "Select curp from curp_rfc where ct =? order by curp";
        //System.out.println("***********************");
        //System.out.println(consultaDatos);
        //System.out.println(ct.getClaveCT());
        try {
            PreparedStatement SPreparada;
            SPreparada= connection.prepareStatement(consultaDatos);
            SPreparada.setString(1, ct.getClaveCT());
            ResultSet resultadoDatosEmpleado=SPreparada.executeQuery();
            while(resultadoDatosEmpleado.next()){
                curp=resultadoDatosEmpleado.getString("curp").trim();
                Empleado empleado = new Empleado(curp);
                empleados.add(empleado);
            }
            //System.out.println("***********************");
            SPreparada.close();
            connection.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
    
    public ArrayList<CentroTrabajo> getCTS(ArrayList<String> array_cts)
    {
        ArrayList<CentroTrabajo> cts = new ArrayList<>();
        for (String ct: array_cts)
        {
            CentroTrabajo centrot = new CentroTrabajo(ct);
            if (!cts.contains(centrot))
            {
                cts.add(centrot);
            }
        }
        return cts;
    }
    
    public ArrayList<Empleado> getEmpleados(ArrayList<String> curps)
    {
        ArrayList<Empleado> empleados = new ArrayList<>();
        for (String curp : curps)
        {
            Empleado empleado = new Empleado(curp);
            if (!empleados.contains(empleado))
            {
                empleados.add(empleado);
            }
        }
        return empleados;
    }
    
    public ArrayList<DocumentoExpediente> getDocumentos(ArrayList<String> docs)
    {
        ArrayList<DocumentoExpediente> documentos = new ArrayList<>();
        ArrayList<String> claves = this.RetornaCT(docs);
        Boolean escaneado;
        for (String clave : conf.CLAVES_DOC)
        {
            if(claves.contains(clave)){
                escaneado = true;
            }
            else
            {
                escaneado = false;
            }
            String nombre = this.DOCUMENTOS.get(clave);
            DocumentoExpediente documento = new DocumentoExpediente(clave, nombre, escaneado);
            if(!documentos.contains(documento))
            {
                documentos.add(documento);
            }
        }
        return documentos;
    }
    
    public ExpedienteEmpleado getDocumentosfromEmpleado(Empleado empleado)
    {
        File f = new File(conf.carpetaCT);
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
        ArrayList<String> documentos = new ArrayList<>();
        String clave = "";
        ExpedienteEmpleado expediente;
        for(String ct : cts){
            String dirCT = conf.carpetaCT + ct.trim();
            File dir_expedientes = new File(dirCT);
            ArrayList<String> curps = new ArrayList<>(Arrays.asList(dir_expedientes.list()));
            for(String curp : curps){
                String dircurp = dirCT + "\\" + curp.trim();
                if(curp.equals(empleado.getCURP()))
                {
                    File doc = new File(dircurp);
                    documentos = new ArrayList<>(Arrays.asList(doc.list()));
                    clave = curp;
                }
            }
        }
        expediente = new ExpedienteEmpleado(this.getDocumentos(documentos), clave);
        return expediente;
    }
    
    public void generarcsv(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        String centrotrabajo = "";
        String curp1 ="";
        String status = "";
        try
        {
            //fichero = new FileWriter("/home/enriquedg/Desktop/dsinteg/escaneos/reporte_estado_expedientes.csv");
            fichero = new FileWriter(conf.carpetaRemota + "reporte_estado_expedientes.csv");
            pw = new PrintWriter(fichero);
            pw.println("Centro de Trabajo,CURP,Estado Expediente,Faltantes");
            File f = new File(conf.carpetaCT);
            ArrayList<String> obli_CM = new ArrayList<>(Arrays.asList(conf.DOC_R));
            obli_CM.add("CM");
            this.conectarbd();
            ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
            ArrayList<String> faltantes;
            String queryct="Select distinct ct from curp_rfc";
            String ct = "";
            try {
                PreparedStatement sentencia;
                sentencia = connection.prepareStatement(queryct);
                ResultSet resultct = sentencia.executeQuery();
                while(resultct.next()){
                    ct = resultct.getString("ct").trim();
                    String query="Select curp from curp_rfc where ct = ?";
                    try {
                        sentencia= connection.prepareStatement(query);
                        sentencia.setString(1, ct.trim());
                        ResultSet result=sentencia.executeQuery();
                        String curp_bd="";
                        if(!cts.contains(ct)){
                            while(result.next()){
                                curp_bd=result.getString("curp").trim();
                                status = "No entregó";
                                faltantes = new ArrayList<>(Arrays.asList(conf.DOC_R));
                                faltantes.add("CM");
                                pw.println(ct + "," + curp_bd + "," + status + "," + faltantes.toString().replace("[", "").replace("]", ""));
                            }
                        }
                        else{
                            String dirCT = conf.carpetaCT + ct.trim();
                            File dir_expedientes = new File(dirCT);
                            ArrayList<String> curps = new ArrayList<>(Arrays.asList(dir_expedientes.list()));
                            while(result.next()){
                                curp_bd=result.getString("curp").trim();
                                if(!curps.contains(curp_bd)){
                                    status = "No entregó";
                                    faltantes = new ArrayList<>(Arrays.asList(conf.DOC_R));
                                    faltantes.add("CM");
                                }
                                else{
                                    String dircurp = dirCT + "\\" + curp_bd.trim();
                                    File doc = new File(dircurp);
                                    ArrayList<String> documentos = new ArrayList<>(Arrays.asList(doc.list()));
                                    ArrayList<String> claves = this.RetornaCT(documentos);
                                    if(documentos.isEmpty()){
                                        status = "No entregó";
                                        faltantes = new ArrayList<>(Arrays.asList(conf.DOC_R));
                                        faltantes.add("CM");
                                    }
                                    else if(documentos.size()==1){
                                        if(claves.get(0).equals("CAS")){
                                            status = "No entregó";
                                            faltantes = new ArrayList<>(Arrays.asList(conf.DOC_R));
                                            faltantes.remove("CAS");
                                            faltantes.add("CM");
                                        }
                                        else{
                                            status = "Incompleto";
                                            if(claves.get(0)=="CM"){
                                                faltantes = new ArrayList<>(Arrays.asList(conf.DOC_R));
                                            }else{
                                                faltantes = new ArrayList<>(Arrays.asList(conf.DOC_R));
                                                faltantes.remove(claves.get(0));
                                                faltantes.add("CM");
                                            }
                                        }
                                    }
                                    else{
                                        faltantes = new ArrayList<>();
                                        ArrayList<String> obli_cedula= new ArrayList<>(Arrays.asList(conf.DOC_R));
                                        obli_cedula.add("CM");
                                        obli_cedula.remove("CUGE");
                                        if(claves.containsAll(obli_cedula) &&
                                                (claves.contains("CPL") || 
                                                 claves.contains("CPM") || 
                                                 claves.contains("CPD")) && 
                                                !claves.contains("CUGE")){
                                            status = "Completo Cédula";
                                            faltantes.add("CUGE");
                                        }
                                        else if(claves.containsAll(obli_CM))
                                            status = "Completo";
                                        else{
                                            status = "Incompleto";
                                            for(String oblis : obli_CM)
                                                if(!claves.contains(oblis))
                                                    faltantes.add(oblis);
                                        }
                                    }
                                }
                                pw.println(ct + "," + curp_bd + "," + status + "," + faltantes.toString().replace("[", "").replace("]", ""));
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdministraScan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            sentencia.close();
            connection.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(AdministraScan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (null != fichero)
                    fichero.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    public ArrayList<SubSistema> verificarexpedientes(){
        File f = new File(conf.carpetaCT); 
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
        //this.generarcsv(cts);
        ArrayList<SubSistema> sub_sistemas = this.getsubsistemas(cts);
        return sub_sistemas;
        //return null;
    }
}
