/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author enriquedg
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class CompresorZIP {
    
    public CompresorZIP(){}
    
    /*solicita la ruta del archivo y su nombre a mostrar*/
    public void comprimirArchivo(String archivo,String nombre) throws FileNotFoundException{
        byte[] buffer = new byte[1024];
        try{
            //System.out.println("Nombre: "+nombre);
            //System.out.println("origen: "+archivo);
            String destinoZip=archivo.substring(0,archivo.length()-(".pdf").length());
            //System.out.println("destino: "+destinoZip);
            FileOutputStream fos = new FileOutputStream(destinoZip+".zip");
            //System.out.println("archivo Zip: "+destinoZip+".zip");
            System.out.println("Comprimiendo archivo: "+nombre+".pdf");
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze= new ZipEntry(nombre+".pdf");
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(archivo);
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();
            //remember close it
            zos.close();
            System.out.println("Comprimido archivo: "+nombre+".pdf");
        }catch(IOException ex){
    	   ex.printStackTrace();
    	}
    }
}

