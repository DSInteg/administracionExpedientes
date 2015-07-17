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
    
    public String RetornaCT(){
        
         //StringBuffer cadena ;
         File f = new File(conf.carpetaCT); 
         String str="";
        ArrayList<String> cts = new ArrayList<String>(Arrays.asList(f.list()));
        String [] doc_r = new String[5];
        ArrayList<String> requeridos = new ArrayList(Arrays.asList(doc_r));
        for (String ct : cts) {
            String dirCT = conf.carpetaCT + ct.trim();
            File dir_expedientes = new File(dirCT);
            ArrayList<String> exp_temp = new ArrayList<String>(Arrays.asList(dir_expedientes.list()));
            for (String expediente : exp_temp){
                File dirDocumentos = new File(dirCT + "\\" + expediente);
                ArrayList<String> documentos = new ArrayList<String>(Arrays.asList(dirDocumentos.list()));
                ArrayList<String> list_doc = new ArrayList<>(); 
        for (String documento : documentos){
                    //System.out.println(documento);
                    
                   StringBuffer cadena=new StringBuffer();      
                            
                    String[] parts_doc = documento.split("_");
                    String [] extension_doc = parts_doc[parts_doc.length-1].split("\\.");
                    String [] resultado = extension_doc[extension_doc.length-2].split("");               
                    cadena =cadena.append(extension_doc[extension_doc.length-2]);
                    str = cadena.toString();
                    System.out.println(str);
            
                }
           
            }
            /*for (Expediente expediente : expedientes)
            {
                //System.out.println(expediente.curp);
            }*/
            
        }
       // return parts_doc[0];
        
                 
        return str;
    }
    
    public verificarexpedientes(){
     
                //ArrayList<String> resultado
                
                
               RetornaCT();
                /*for(String requerido : requeridos){
                    if (!list_doc.contains(requerido)){
                        expediente.faltantes.add(requerido);
                    }
                }*/
        
        
        
    }
}//fin de todo
