/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author LUIS A
 */
public class ViewVendedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewVendedor
     */
    public ViewVendedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BordeAbajo = new javax.swing.JPanel();
        BordeArriba = new javax.swing.JPanel();
        btnConsultarinv = new javax.swing.JButton();
        btnRealizarven = new javax.swing.JButton();
        btnConsultarinv1 = new javax.swing.JButton();
        btnRealizarven1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setText("Bienvenido Señor Vendedor");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/png-transparent-yamaha-logo-yamaha-motor-company-logo-yamaha-corporation-decal-yamaha-emblem-company-motorcycle-thumbnail-removebg-preview.png"))); // NOI18N

        BordeAbajo.setBackground(new java.awt.Color(227, 14, 21));
        BordeAbajo.setForeground(new java.awt.Color(227, 14, 21));

        javax.swing.GroupLayout BordeAbajoLayout = new javax.swing.GroupLayout(BordeAbajo);
        BordeAbajo.setLayout(BordeAbajoLayout);
        BordeAbajoLayout.setHorizontalGroup(
            BordeAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        BordeAbajoLayout.setVerticalGroup(
            BordeAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        BordeArriba.setBackground(new java.awt.Color(227, 14, 21));
        BordeArriba.setForeground(new java.awt.Color(227, 14, 21));

        javax.swing.GroupLayout BordeArribaLayout = new javax.swing.GroupLayout(BordeArriba);
        BordeArriba.setLayout(BordeArribaLayout);
        BordeArribaLayout.setHorizontalGroup(
            BordeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        BordeArribaLayout.setVerticalGroup(
            BordeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        btnConsultarinv.setBackground(new java.awt.Color(255, 0, 0));
        btnConsultarinv.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnConsultarinv.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarinv.setText("Consultar Inventario");

        btnRealizarven.setBackground(new java.awt.Color(255, 0, 0));
        btnRealizarven.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRealizarven.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarven.setText("Realizar Venta");
        btnRealizarven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarvenActionPerformed(evt);
            }
        });

        btnConsultarinv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2025-01-16 153252.png"))); // NOI18N

        btnRealizarven1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2025-01-16 153445.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(btnConsultarinv1)
                .addGap(238, 238, 238)
                .addComponent(btnRealizarven1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultarinv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizarven, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(318, 318, 318))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BordeArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BordeAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(477, 477, 477)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRealizarven1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsultarinv1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarven, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarinv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(291, 291, 291))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(BordeArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(398, 398, 398)
                    .addComponent(BordeAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarvenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarvenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BordeAbajo;
    private javax.swing.JPanel BordeArriba;
    private javax.swing.JButton btnConsultarinv;
    private javax.swing.JButton btnConsultarinv1;
    private javax.swing.JButton btnRealizarven;
    private javax.swing.JButton btnRealizarven1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
