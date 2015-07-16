
package administraScan;

/**
 *

 * @author enriquedg
 */
public class Configuracion {
    //Carpetas
    //Datos locales
    final String carpetaRemota="/home/enriquedg/Desktop/dsinteg/escaneos/";
    final String USUARIO="root";
    final String PASSWORD="cruzazul";
    final String carpetaCT = this.carpetaRemota + "aceptadosCT/";
    /*
    //Datos remotos
    final String carpetaRemota="c:\\escaneos\\";
    final String carpetaCT = this.carpetaRemota + "aceptadosCT\\";
    final String USUARIO="curp";
    final String PASSWORD="curpuset";*/
    final String DATABASE_URL="jdbc:mysql://127.0.0.1/curp_uset";
}