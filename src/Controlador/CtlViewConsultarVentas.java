/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoUsuario;
import Modelo.DaoVentasMotos;
import Modelo.Persona;
import Vista.ViewCerrarSesionAdmin;
import Vista.ViewConsultarVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 *
 * @author User
 */
public class CtlViewConsultarVentas implements ActionListener {

    private ViewCerrarSesionAdmin vCerrAdm;
    private ViewConsultarVentas vConsultarVentas;
    private DaoVentasMotos dVM;
    private DefaultTableModel modelo;
    private DaoUsuario daousuario;

    public CtlViewConsultarVentas(ViewCerrarSesionAdmin vCerrAdm, ViewConsultarVentas vConsultarVentas, DaoVentasMotos dVM, DaoUsuario daousuario) {
        this.vCerrAdm = vCerrAdm;
        this.vConsultarVentas = vConsultarVentas;
        this.dVM = dVM;
        this.modelo = modelo;
        this.daousuario = daousuario;
        
        this.vConsultarVentas.btnCerrarSesion.addActionListener(this);
        this.vConsultarVentas.btnConsultar.addActionListener(this);
        initTabla();
    }
    
    

    public void initTabla() {
        String[] titulos = {"fecha de venta", "total de esta venta"};
        modelo = new DefaultTableModel(titulos, 2);
        vConsultarVentas.tablaVentasEmpleados.setModel(modelo);
    }

    public void llenarTabla() {
        modelo.setRowCount(0);
        ResultSet rst = dVM.consultarVentasXVendedor(vConsultarVentas.txtIdEmpleado.getText());
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            while (rst.next()) {
                Object[] row = new Object[2];
                row[0] = rst.getDate("fecha de venta");
                row[1] = df.format(rst.getDouble("total de esta venta"));

                
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vConsultarVentas.btnCerrarSesion)) {
            vCerrAdm.setVisible(true);
            vConsultarVentas.dispose();
        }
        if (e.getSource().equals(vConsultarVentas.btnConsultar)) {
            llenarTabla();
            Persona persona = new Persona();
            vConsultarVentas.txtEmpleadoNombre.setText(daousuario.obtenerNombrePorId(Integer.parseInt(vConsultarVentas.txtIdEmpleado.getText())));
        }
    }
}
