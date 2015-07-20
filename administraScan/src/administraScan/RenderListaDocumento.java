/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Eli
 */
public class RenderListaDocumento extends JLabel implements ListCellRenderer{
    
    final static ImageIcon iconoe = new ImageIcon("/img/encontrado.png");
    final static ImageIcon iconone = new ImageIcon("/img/faltante.png");
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String valor = value.toString();
        String [] valores = valor.split("\\*");
        String nombre = valores[0];
        String escaneado = valores[1];
        System.out.println(nombre);
        System.out.println(escaneado);
        if(escaneado.equals("true")){
            setIcon(iconoe);
            setForeground(Color.blue);
        }
        else{
            setIcon(iconone);
            setForeground(Color.red);
        }
        setText(nombre);
        //To change body of generated methods, choose Tools | Templates.
        return this;
    }
    
        
    
}
