/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author grabieloX19X
 */
public class ViewAgregarVendedor extends javax.swing.JFrame {

    /**
     * Creates new form ViewAgregarVendedor
     */
    public ViewAgregarVendedor() {
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        btnEliminar = new Vista.MyButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCC = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNumTelefonico = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtIDSucursal = new javax.swing.JTextField();
        btnAcceder1 = new Vista.MyButton();
        btnActualizar1 = new Vista.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 1300, -1));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1175, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        btnEliminar.setBackground(new java.awt.Color(227, 14, 21));
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setForeground(new java.awt.Color(242, 242, 242));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorderColor(new java.awt.Color(242, 242, 242));
        btnEliminar.setBorderPainted(false);
        btnEliminar.setColor(new java.awt.Color(227, 14, 21));
        btnEliminar.setColorClick(new java.awt.Color(227, 14, 21));
        btnEliminar.setColorOver(new java.awt.Color(167, 14, 21));
        btnEliminar.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnEliminar.setRadius(30);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 740, 260, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Apellidos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("C.C.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setText("Numero telefonico");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("Direccion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setText("Username");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setText("Contrasena");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel9.setText("Salario");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setText("ID sucursal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 590, -1, -1));

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 440, -1));

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 440, -1));

        txtCC.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 440, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 440, -1));

        txtNumTelefonico.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtNumTelefonico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumTelefonicoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumTelefonico, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 340, -1));

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 310, 320, -1));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 380, 320, -1));

        txtContrasena.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 320, -1));

        txtSalario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 520, 320, -1));

        txtIDSucursal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel1.add(txtIDSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 590, 320, -1));

        btnAcceder1.setBackground(new java.awt.Color(227, 14, 21));
        btnAcceder1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAcceder1.setForeground(new java.awt.Color(242, 242, 242));
        btnAcceder1.setText("Agregar vendedor");
        btnAcceder1.setBorderColor(new java.awt.Color(242, 242, 242));
        btnAcceder1.setBorderPainted(false);
        btnAcceder1.setColor(new java.awt.Color(227, 14, 21));
        btnAcceder1.setColorClick(new java.awt.Color(227, 14, 21));
        btnAcceder1.setColorOver(new java.awt.Color(167, 14, 21));
        btnAcceder1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnAcceder1.setRadius(30);
        btnAcceder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceder1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAcceder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 740, 260, 50));

        btnActualizar1.setBackground(new java.awt.Color(227, 14, 21));
        btnActualizar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar1.setForeground(new java.awt.Color(242, 242, 242));
        btnActualizar1.setText("Actualizar");
        btnActualizar1.setBorderColor(new java.awt.Color(242, 242, 242));
        btnActualizar1.setBorderPainted(false);
        btnActualizar1.setColor(new java.awt.Color(227, 14, 21));
        btnActualizar1.setColorClick(new java.awt.Color(227, 14, 21));
        btnActualizar1.setColorOver(new java.awt.Color(167, 14, 21));
        btnActualizar1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnActualizar1.setRadius(30);
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 740, 260, 50));

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtNumTelefonicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumTelefonicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumTelefonicoActionPerformed

    private void btnAcceder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcceder1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizar1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Vista.MyButton btnAcceder1;
    public Vista.MyButton btnActualizar1;
    public javax.swing.JButton btnCerrarSesion;
    public Vista.MyButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCC;
    public javax.swing.JTextField txtContrasena;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtIDSucursal;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtNumTelefonico;
    public javax.swing.JTextField txtSalario;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
