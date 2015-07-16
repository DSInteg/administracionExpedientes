package administraScan;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan
 */
public class frmAdministraScan extends javax.swing.JFrame {

    /**
     * Creates new form frmAdministraScan
     */
    public frmAdministraScan() {
        initComponents();
        visualizaSubSistemas();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtExpedientesEscaneados = new javax.swing.JLabel();
        txtExpedientesCompletos = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        panelSubSistema = new javax.swing.JPanel();
        scrollSubSistema = new javax.swing.JScrollPane();
        listaSubSistema = new javax.swing.JList();
        panelCT = new javax.swing.JPanel();
        scrollCT = new javax.swing.JScrollPane();
        listaCT = new javax.swing.JList();
        panelCURP = new javax.swing.JPanel();
        scrollPlantilla = new javax.swing.JScrollPane();
        listaPlantilla = new javax.swing.JList();
        panelDocumentos = new javax.swing.JPanel();
        scrollDocumentos = new javax.swing.JScrollPane();
        listaDocumentos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCabecera.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("UNIDAD DE SERVICIOS EDUCATIVOS DE TLAXCALA");

        jLabel2.setText("ESCANEO DE EXPEDIENTES LABORALES");

        jLabel3.setText("Expedientes Escaneados:");

        jLabel4.setText("Expedientes Completos:");

        txtExpedientesEscaneados.setText("100000");

        txtExpedientesCompletos.setText("100000");

        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button1.setLabel("Organizar Directorios");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabeceraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtExpedientesEscaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExpedientesCompletos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCabeceraLayout.createSequentialGroup()
                        .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCabeceraLayout.createSequentialGroup()
                                .addGap(344, 344, 344)
                                .addComponent(jLabel2))
                            .addGroup(panelCabeceraLayout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabeceraLayout.createSequentialGroup()
                        .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtExpedientesEscaneados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtExpedientesCompletos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(panelCabeceraLayout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelSubSistema.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listaSubSistema.setBackground(new java.awt.Color(240, 240, 240));
        listaSubSistema.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaSubSistema.setForeground(new java.awt.Color(255, 255, 255));
        listaSubSistema.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaSubSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaSubSistema.setFocusable(false);
        listaSubSistema.setRequestFocusEnabled(false);
        listaSubSistema.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listaSubSistema.setVerifyInputWhenFocusTarget(false);
        listaSubSistema.setVisibleRowCount(0);
        scrollSubSistema.setViewportView(listaSubSistema);

        javax.swing.GroupLayout panelSubSistemaLayout = new javax.swing.GroupLayout(panelSubSistema);
        panelSubSistema.setLayout(panelSubSistemaLayout);
        panelSubSistemaLayout.setHorizontalGroup(
            panelSubSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
            .addGroup(panelSubSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSubSistemaLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(scrollSubSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        panelSubSistemaLayout.setVerticalGroup(
            panelSubSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
            .addGroup(panelSubSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSubSistemaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollSubSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panelCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listaCT.setBackground(new java.awt.Color(240, 240, 240));
        listaCT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaCT.setForeground(new java.awt.Color(102, 102, 102));
        listaCT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaCT.setFocusable(false);
        listaCT.setRequestFocusEnabled(false);
        listaCT.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listaCT.setVerifyInputWhenFocusTarget(false);
        listaCT.setVisibleRowCount(0);
        scrollCT.setViewportView(listaCT);

        javax.swing.GroupLayout panelCTLayout = new javax.swing.GroupLayout(panelCT);
        panelCT.setLayout(panelCTLayout);
        panelCTLayout.setHorizontalGroup(
            panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
            .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCTLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(scrollCT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        panelCTLayout.setVerticalGroup(
            panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCTLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollCT, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panelCURP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listaPlantilla.setBackground(new java.awt.Color(240, 240, 240));
        listaPlantilla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaPlantilla.setForeground(new java.awt.Color(102, 102, 102));
        listaPlantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaPlantilla.setFocusable(false);
        listaPlantilla.setRequestFocusEnabled(false);
        listaPlantilla.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listaPlantilla.setVerifyInputWhenFocusTarget(false);
        listaPlantilla.setVisibleRowCount(0);
        scrollPlantilla.setViewportView(listaPlantilla);

        javax.swing.GroupLayout panelCURPLayout = new javax.swing.GroupLayout(panelCURP);
        panelCURP.setLayout(panelCURPLayout);
        panelCURPLayout.setHorizontalGroup(
            panelCURPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
            .addGroup(panelCURPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCURPLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(scrollPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        panelCURPLayout.setVerticalGroup(
            panelCURPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelCURPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCURPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panelDocumentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listaDocumentos.setBackground(new java.awt.Color(240, 240, 240));
        listaDocumentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaDocumentos.setForeground(new java.awt.Color(102, 102, 102));
        listaDocumentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaDocumentos.setFocusable(false);
        listaDocumentos.setRequestFocusEnabled(false);
        listaDocumentos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listaDocumentos.setVerifyInputWhenFocusTarget(false);
        listaDocumentos.setVisibleRowCount(0);
        scrollDocumentos.setViewportView(listaDocumentos);

        javax.swing.GroupLayout panelDocumentosLayout = new javax.swing.GroupLayout(panelDocumentos);
        panelDocumentos.setLayout(panelDocumentosLayout);
        panelDocumentosLayout.setHorizontalGroup(
            panelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
            .addGroup(panelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDocumentosLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(scrollDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        panelDocumentosLayout.setVerticalGroup(
            panelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDocumentosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSubSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSubSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCURP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        
        OrganizaDirectorios obj=new OrganizaDirectorios();
        obj.clasificar();
    }//GEN-LAST:event_button1ActionPerformed
    //debe de pintar en el JList listaSubSistema los subsistemas
   public void visualizaSubSistemas(){
    
}
   //pinta en el JList listaCT la clave de todos los CT del subsistemas
   public void visualizaCTSubSistema(){
       
   }
   
   //pinta en el Jlist listaPlantilla la clave CURP de los empleados de ese CT
   public void visualizaPlantillaCT(){
       
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdministraScan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdministraScan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdministraScan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdministraScan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdministraScan().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList listaCT;
    private javax.swing.JList listaDocumentos;
    private javax.swing.JList listaPlantilla;
    private javax.swing.JList listaSubSistema;
    private javax.swing.JPanel panelCT;
    private javax.swing.JPanel panelCURP;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelDocumentos;
    private javax.swing.JPanel panelSubSistema;
    private javax.swing.JScrollPane scrollCT;
    private javax.swing.JScrollPane scrollDocumentos;
    private javax.swing.JScrollPane scrollPlantilla;
    private javax.swing.JScrollPane scrollSubSistema;
    private javax.swing.JLabel txtExpedientesCompletos;
    private javax.swing.JLabel txtExpedientesEscaneados;
    // End of variables declaration//GEN-END:variables
}
