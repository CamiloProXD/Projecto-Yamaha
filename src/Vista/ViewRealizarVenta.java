/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author juanc
 */
public class ViewRealizarVenta extends javax.swing.JFrame {

    /**
     * Creates new form ViewRealizarVentaa
     */
    public ViewRealizarVenta() {
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
        jLabel1 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelapellido = new javax.swing.JLabel();
        labelcedula = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelDirec = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        LabelMod = new javax.swing.JLabel();
        LabelColor = new javax.swing.JLabel();
        LabePrec = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        TxtCedula = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        txtDirec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelPlaca = new javax.swing.JLabel();
        txttipo = new javax.swing.JTextField();
        txtmodelo = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        TxtColor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAbonado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        botonMenu = new javax.swing.JButton();
        btnGenerarFactura = new Vista.MyButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Realizar venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 95, -1, -1));

        labelCliente.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        labelCliente.setForeground(new java.awt.Color(0, 0, 0));
        labelCliente.setText("Cliente ");
        jPanel1.add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 169, 158, -1));

        labelNombre.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(0, 0, 0));
        labelNombre.setText("Nombre");
        jPanel1.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 246, -1, -1));

        labelapellido.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelapellido.setForeground(new java.awt.Color(0, 0, 0));
        labelapellido.setText("Apellido");
        jPanel1.add(labelapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 332, -1, -1));

        labelcedula.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelcedula.setForeground(new java.awt.Color(0, 0, 0));
        labelcedula.setText("Cedúla");
        jPanel1.add(labelcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 504, -1, -1));

        labelNumero.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelNumero.setForeground(new java.awt.Color(0, 0, 0));
        labelNumero.setText("Contacto");
        jPanel1.add(labelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 418, -1, -1));

        labelDirec.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelDirec.setForeground(new java.awt.Color(0, 0, 0));
        labelDirec.setText("Dirección");
        jPanel1.add(labelDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 590, -1, -1));

        labelTipo.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelTipo.setForeground(new java.awt.Color(0, 0, 0));
        labelTipo.setText("Tipo");
        jPanel1.add(labelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 246, -1, -1));

        LabelMod.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        LabelMod.setForeground(new java.awt.Color(0, 0, 0));
        LabelMod.setText("Modelo");
        jPanel1.add(LabelMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 332, -1, -1));

        LabelColor.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        LabelColor.setForeground(new java.awt.Color(0, 0, 0));
        LabelColor.setText("Color");
        jPanel1.add(LabelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 590, -1, -1));

        LabePrec.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        LabePrec.setForeground(new java.awt.Color(0, 0, 0));
        LabePrec.setText("Precio");
        jPanel1.add(LabePrec, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 418, -1, -1));

        TxtNombre.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 286, 225, -1));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 372, 225, -1));

        TxtCedula.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(TxtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 544, 225, -1));

        TxtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 458, 225, -1));

        txtDirec.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 630, 225, -1));

        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Moto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 169, -1, -1));

        labelPlaca.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        labelPlaca.setForeground(new java.awt.Color(0, 0, 0));
        labelPlaca.setText("Placa");
        jPanel1.add(labelPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 504, -1, -1));

        txttipo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txttipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 286, 190, -1));

        txtmodelo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 372, 190, -1));

        txtprecio.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 458, 190, -1));

        txtPlaca.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 544, 190, -1));

        TxtColor.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(TxtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 630, 190, -1));

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Precio abonado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 676, -1, -1));

        txtAbonado.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtAbonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 716, 225, -1));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        botonRegresar.setBackground(new java.awt.Color(255, 255, 255));
        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"))); // NOI18N
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        botonMenu.setBackground(new java.awt.Color(255, 255, 255));
        botonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/casa.png"))); // NOI18N
        botonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(botonRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonMenu)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonMenu)
                    .addComponent(botonRegresar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        btnGenerarFactura.setBackground(new java.awt.Color(227, 14, 21));
        btnGenerarFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarFactura.setForeground(new java.awt.Color(242, 242, 242));
        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.setBorderColor(new java.awt.Color(242, 242, 242));
        btnGenerarFactura.setBorderPainted(false);
        btnGenerarFactura.setColor(new java.awt.Color(227, 14, 21));
        btnGenerarFactura.setColorClick(new java.awt.Color(227, 14, 21));
        btnGenerarFactura.setColorOver(new java.awt.Color(167, 14, 21));
        btnGenerarFactura.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnGenerarFactura.setRadius(30);
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 734, 223, 60));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 823, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed

    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuActionPerformed

    }//GEN-LAST:event_botonMenuActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabePrec;
    private javax.swing.JLabel LabelColor;
    private javax.swing.JLabel LabelMod;
    public javax.swing.JTextField TxtCedula;
    public javax.swing.JTextField TxtColor;
    public javax.swing.JTextField TxtNombre;
    public javax.swing.JTextField TxtTelefono;
    private javax.swing.JButton botonMenu;
    private javax.swing.JButton botonRegresar;
    public Vista.MyButton btnGenerarFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelDirec;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelPlaca;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelapellido;
    private javax.swing.JLabel labelcedula;
    public javax.swing.JTextField txtAbonado;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtDirec;
    public javax.swing.JTextField txtPlaca;
    public javax.swing.JTextField txtmodelo;
    public javax.swing.JTextField txtprecio;
    public javax.swing.JTextField txttipo;
    // End of variables declaration//GEN-END:variables
}
