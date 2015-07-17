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
            System.out.println(subs.getClaveSubSistema());
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
                System.out.println(centrot.getClaveCT());
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
                System.out.println(empleado.getCURP());
            }
        }
        return empleados;
    }
    
    public ArrayList<DocumentoExpediente> getDocumentos(ArrayList<String> docs)
    {
        ArrayList<DocumentoExpediente> documentos = new ArrayList<>();
        for (String doc : docs)
        {
            DocumentoExpediente documento = new DocumentoExpediente(doc);
            if(!documentos.contains(documento))
            {
                documentos.add(documento);
                System.out.println(documento.getClave());
            }
        }
        return documentos;
    }
    
    public void verificarexpedientes(){
        File f = new File(conf.carpetaCT); 
        ArrayList<String> cts = new ArrayList<>(Arrays.asList(f.list()));
        String [] doc_r = {"IO", "RFC", "CURP", "AN", "CD","CAS", "CUGE"};
        ArrayList<String> requeridos = new ArrayList<>(Arrays.asList(doc_r));
        System.out.println(cts);
        ArrayList<SubSistema> sub_sistemas = this.getsubsistemas(cts);
        ArrayList<CentroTrabajo> centros_trabajo = this.getCTS(cts);
        for (String ct : cts) {
            String dirCT = conf.carpetaCT + ct.trim();
            File dir_expedientes = new File(dirCT);
            ArrayList<String> exp_temp = new ArrayList<String>(Arrays.asList(dir_expedientes.list()));
            ArrayList<Empleado> empleado = this.getEmpleados(exp_temp);
            for (String exp : exp_temp){
                File dirDocumentos = new File(dirCT + "/" + exp);
                ArrayList<String> docs = new ArrayList<String>(Arrays.asList(dirDocumentos.list()));
                ExpedienteEmpleado expediente = new ExpedienteEmpleado(this.getDocumentos(docs));
                System.out.println("Expediente: " + exp);
                ArrayList<String> list_doc = new ArrayList<String>();
                /*for (String documento : documentos){
                    System.out.println(documento);
                    String[] parts_doc = documento.split("_");
                    System.out.println(parts_doc[1]);
                    list_doc.add(parts_doc[1]);
                }*/
                /*for(String requerido : requeridos){
                    if (!list_doc.contains(requerido)){
                        expediente.faltantes.add(requerido);
                    }
                }*/
            }
            /*for (Expediente expediente : expedientes)
            {
                System.out.println(expediente.curp);
            }*/
            
        }
    }
}
