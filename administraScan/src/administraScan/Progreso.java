/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administraScan;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Eli
 */
public class Progreso extends SwingWorker<Integer, String> {
    private JProgressBar jProgressBar;
    private JLabel labelProgreso;
    
    

    public Progreso(JProgressBar jProgressBar, JLabel labelProgreso) {
        this.jProgressBar = jProgressBar;
        this.labelProgreso = labelProgreso;
         
    }
    

    @Override
    protected Integer doInBackground() throws Exception {
        
        getLabelProgreso().setVisible(true);
        getjProgressBar().setIndeterminate(true);
        OrganizaDirectorios tamanio= new OrganizaDirectorios();
        int a=tamanio.retornaSize();
     

           try {
             for(int i=0;i<a;i++){
        getLabelProgreso().setVisible(true);
        getjProgressBar().setIndeterminate(true);
                 Thread.sleep(100);
                 System.out.println("Entré al for de doinBackground");
            }
        getLabelProgreso().setVisible(false);
       // getjProgressBar().setVisible(false);
        //getjProgressBar().setVisible(true);
        getjProgressBar().setIndeterminate(false);

        } catch (Exception e) {
            System.out.println("hay un error al entrar"+e);
        }
            

    
        
    return 0;
    
    }

    /**
     * @return the jProgressBar
     */
    public JProgressBar getjProgressBar() {
        return jProgressBar;
    }

    /**
     * @param jProgressBar the jProgressBar to set
     */
    public void setjProgressBar(JProgressBar jProgressBar) {
        this.jProgressBar = jProgressBar;
    }

    /**
     * @return the labelProgreso
     */
    public JLabel getLabelProgreso() {
        return labelProgreso;
    }

    /**
     * @param labelProgreso the labelProgreso to set
     */
    public void setLabelProgreso(JLabel labelProgreso) {
        this.labelProgreso = labelProgreso;
    }
    
    
    
    
}
