/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author enriquedg
 */
public class AdministraScan {
    private final Configuracion conf;
    HashMap<String, String> DOCUMENTOS;
    
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
        for(String nombre : nombres){
            String str="";
            StringBuffer cadena = new StringBuffer();
            String[] parts_doc = nombre.split("_");
            String [] extension_doc = parts_doc[parts_doc.length-1].split("\\.");
            String [] resultado = extension_doc[extension_doc.length-2].split("");
            cadena =cadena.append(extension_doc[extension_doc.length-2]);
            str = cadena.toString();
            if(!claves.contains(str)){
                claves.add(str);
            }
        }
        return claves;
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
            DocumentoExpediente documento = new DocumentoExpediente(clave, escaneado);
            if(!documentos.contains(documento))
            {
                documentos.add(documento);
            }
        }
        return documentos;
    }
    
    public void verificarexpedientes(){
        File f = new File(conf.carpetaCT); 
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
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
                for (Empleado empleado : empleados)
                {
                    if (centrot.getClaveCT().equals(empleado.getCTEmpleado().getClaveCT()))
                    {
                        centrot.addEmpleado(empleado);
                    }
                    
                }
            }
        }
        for(CentroTrabajo centrot : centros_trabajo)
        {
            System.out.println("CT: " + centrot.getClaveCT());
            for(Empleado empleado: centrot.getPantillaEmpleados())
            {
                System.out.println("Empleado " + empleado.getCURP());
                for(DocumentoExpediente documento : empleado.getExpediente().getDocumentacion())
                {
                    System.out.println("Documentos: " + documento.getClave());
                    System.out.println("Documentos: " + this.DOCUMENTOS.get(documento.getClave()));
                    System.out.println("Documentos: " + documento.getEscaneado());
                }
            }
        }
    }
}