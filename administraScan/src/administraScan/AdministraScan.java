/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author enriquedg
 */
public class AdministraScan {
    private final Configuracion conf;
    
    public AdministraScan(){
        this.conf = new Configuracion();
    }
    
    public String RetornaCT(String nombre){
        String str="";
        StringBuffer cadena = new StringBuffer();                          
        String[] parts_doc = nombre.split("_");
        String [] extension_doc = parts_doc[parts_doc.length-1].split("\\.");
        String [] resultado = extension_doc[extension_doc.length-2].split("");
        cadena =cadena.append(extension_doc[extension_doc.length-2]);
        str = cadena.toString();
        //System.out.println(str);
        return str;
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
            //System.out.println(subs.getClaveSubSistema());
            subsistemas.add(subs);
        }
        return subsistemas;
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
                //System.out.println(centrot.getClaveCT());
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
                //System.out.println(empleado.getCURP());
            }
        }
        return empleados;
    }
    
    public ArrayList<DocumentoExpediente> getDocumentos(ArrayList<String> docs)
    {
        ArrayList<DocumentoExpediente> documentos = new ArrayList<>();
        for (String doc : docs)
        {
            String clave = this.RetornaCT(doc);
            DocumentoExpediente documento = new DocumentoExpediente(clave);
            if(!documentos.contains(documento))
            {
                documentos.add(documento);
                //System.out.println(documento.getClave());
                //System.out.println(documento.getObligatorio());
            }
        }
        return documentos;
    }
    
    public void verificarexpedientes(){
        File f = new File(conf.carpetaCT); 
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
        //System.out.println(cts);
        ArrayList<SubSistema> sub_sistemas = this.getsubsistemas(cts);
        ArrayList<CentroTrabajo> centros_trabajo = this.getCTS(cts);
        for (String ct : cts) {
            String dirCT = conf.carpetaCT + ct.trim();
            File dir_expedientes = new File(dirCT);
            ArrayList<String> exp_temp = new ArrayList<String>(Arrays.asList(dir_expedientes.list()));
            ArrayList<Empleado> empleados = this.getEmpleados(exp_temp);
            for (String exp : exp_temp)
            {
                File dirDocumentos = new File(dirCT + "/" + exp);
                ArrayList<String> docs = new ArrayList<String>(Arrays.asList(dirDocumentos.list()));
                ExpedienteEmpleado expediente = new ExpedienteEmpleado(this.getDocumentos(docs), exp);
                //System.out.println("Expediente: " + exp);
                for (Empleado empleado : empleados)
                {
                    if(empleado.getCURP().equals(expediente.getClave()))
                    {
                        empleado.setExpediente(expediente);
                    }
                }
                //ArrayList<String> list_doc = new ArrayList<String>();
                /*for(String requerido : requeridos){
                    if (!list_doc.contains(requerido)){
                        expediente.faltantes.add(requerido);
                    }
                }*/
            }
            for (CentroTrabajo centrot : centros_trabajo)
            {
                System.out.println("Centro Trabajo: " + centrot.getClaveCT());
                for (Empleado empleado : empleados)
                {
                    System.out.println("**************");
                    System.out.println("Empleado: " + empleado.getCURP());
                    //System.out.println("Clave CT " + empleado.getCTEmpleado().getClaveCT());
                    System.out.println("**************");
                    /*if (centrot.getClaveCT().equals(empleado.getCTEmpleado().getClaveCT()))
                    {
                        centrot.addEmpleado(empleado);
                    }*/
                    
                }
            }
            for(Empleado empleado : empleados)
            {
                System.out.println("Empleado: " + empleado.getCURP());
                System.out.println("Expediente: " + empleado.getExpediente().getClave());
                System.out.println("# de documentos: " + empleado.getExpediente().getDocumentacion().size());
            }
        }
        /*for(Empleado empleado : empleados)
        {
            System.out.println("********************+");
            System.out.println("Empleado: " + empleado.getCURP());
            System.out.println("Expediente: " + empleado.getExpediente().getClave());
            System.out.println("# de documentos: " + empleado.getExpediente().getDocumentacion().size());
        }*/
        /*for (CentroTrabajo centrot : centros_trabajo)
        {
            if(!centrot.getPantillaEmpleados().isEmpty()){
                for (Empleado empleado : centrot.getPantillaEmpleados())
                {
                    System.out.println(empleado.getCURP());
                    System.out.println("------------------");
                }
            }
        }*/
    }
}