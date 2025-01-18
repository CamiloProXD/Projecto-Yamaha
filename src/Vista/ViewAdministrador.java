/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author juanc
 */
public class ViewAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form ViewAdministradorr
     */
    public ViewAdministrador() {
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

        jPanel1 = new javax.swing.JPanel();
        txtbienvenida = new javax.swing.JLabel();
        AgregarMoto = new javax.swing.JButton();
        TxtAgregar = new javax.swing.JLabel();
        btnVerInventario = new javax.swing.JButton();
        TxtInventario = new javax.swing.JLabel();
        ConsultarVentas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        RegresaMenuPrincipal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbienvenida.setBackground(new java.awt.Color(0, 0, 0));
        txtbienvenida.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        txtbienvenida.setText("Bienvenido Administrador");
        jPanel1.add(txtbienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 750, 50));

        AgregarMoto.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        AgregarMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/moto (1).png"))); // NOI18N
        AgregarMoto.setAutoscrolls(true);
        AgregarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarMotoActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 180, 150));

        TxtAgregar.setBackground(new java.awt.Color(0, 0, 0));
        TxtAgregar.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        TxtAgregar.setText("Agregar moto");
        jPanel1.add(TxtAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 190, 70));

        btnVerInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario.png"))); // NOI18N
        btnVerInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 180, 150));

        TxtInventario.setBackground(new java.awt.Color(0, 0, 0));
        TxtInventario.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        TxtInventario.setText("Ver Inventario");
        jPanel1.add(TxtInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        ConsultarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/metodo-de-pago.png"))); // NOI18N
        ConsultarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarVentasActionPerformed(evt);
            }
        });
        jPanel1.add(ConsultarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 440, 180, 150));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel4.setText("Consultar Ventas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 320, -1, 20));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 860, 1300, 40));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        RegresaMenuPrincipal.setForeground(new java.awt.Color(51, 255, 255));
        RegresaMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegresaMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1243, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegresaMenuPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarMotoActionPerformed

    }//GEN-LAST:event_AgregarMotoActionPerformed

    private void btnVerInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInventarioActionPerformed

    }//GEN-LAST:event_btnVerInventarioActionPerformed

    private void ConsultarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarVentasActionPerformed

    }//GEN-LAST:event_ConsultarVentasActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarMoto;
    private javax.swing.JButton ConsultarVentas;
    private javax.swing.JButton RegresaMenuPrincipal;
    private javax.swing.JLabel TxtAgregar;
    private javax.swing.JLabel TxtInventario;
    private javax.swing.JButton btnVerInventario;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel txtbienvenida;
    // End of variables declaration//GEN-END:variables
}
