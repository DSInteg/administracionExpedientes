
package administraScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *

 * @author enriquedg
 */
public class Configuracion {
    //Carpetas
    final String carpetaRemota="c:\\escaneos\\";
    final String carpetaCT = this.carpetaRemota + "aceptadosCT\\";
    final String carpetaCAS = this.carpetaRemota + "constanciasAS\\";
    //final String carpetaRemota="/home/enriquedg/Desktop/dsinteg/escaneos/";
    //final String carpetaCT = this.carpetaRemota + "aceptadosCT/";
    //final String carpetaLocal="/home/eli-vaio/Desktop/dsinteg/escaneos/";
    //Base de Datos local
    final String USUARIO="curp";
    final String PASSWORD="curpuset";
    final String DATABASE_URL="jdbc:mysql://127.0.0.1/curp_uset";
    private String [] DOC_R = {"IO", "RFC", "CURP", "AN", "CD", "CAS", "CUGE"};
    final ArrayList<String> OBLIGATORIOS = new ArrayList<>(Arrays.asList(DOC_R));
    final String [] NOMBRES_DOC = {"Identificacion Oficial", "RFC", "CURP",
        "Acta de Nacimiento", "Cartilla Militar", "Carta de Naturalizacion",
        "Forma Migratoria", "Comprobante de Domicilio", "Estado de Cuenta",
        "Constancia de Años de Servicio", "Constancia de Ultimo Grado de Estudios",
        "Cédula Profesional Licenciatura", "Cédula Profesional Maestria",
        "Cédula Profesional Doctorado", "Acta de Nacimiento de Familiar",
        "Acta de Matrimonio", "Acta de Dependencia Económica", "Acta de Concubinato"};
    final String [] CLAVES_DOC = {"IO", "RFC", "CURP", "AN", "CM", "CN", "FM", "CD",
        "EC", "CAS", "CUGE", "CPL", "CPM", "CPD", "ANB", "AM", "ADE", "AC"};
}