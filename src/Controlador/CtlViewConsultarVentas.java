/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoVentasMotos;
import Modelo.Persona;
import Vista.ViewCerrarSesionAdmin;
import Vista.ViewConsultarVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class CtlViewConsultarVentas implements ActionListener {

    private ViewCerrarSesionAdmin vCerrAdm;
    private ViewConsultarVentas vConsultarVentas;
    private DaoVentasMotos dVM;
    private DefaultTableModel modelo;

    public void initTabla() {
        String[] titulos = {"fecha de venta", "total de esta venta"};
        modelo = new DefaultTableModel(titulos, 2);
        vConsultarVentas.tablaVentasEmpleados.setModel(modelo);
    }

    public void llenarTabla() {
        modelo.setRowCount(0);
        ResultSet rst = dVM.consultarVentasXVendedor(vConsultarVentas.txtIdEmpleado.getText(), vConsultarVentas.txtFechaInicial.getText(), vConsultarVentas.txtFechaFinal.getText());
        try {
            while (rst.next()) {
                Object[] row = new Object[2];
                row[0] = rst.getDate("fecha de venta");
                row[1] = rst.getDouble("total de esta venta");

                // Add the row to the table model
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
            dVM.consultarVentasXVendedor(vConsultarVentas.txtIdEmpleado.getText(), vConsultarVentas.txtFechaInicial.getText(), vConsultarVentas.txtFechaFinal.getText());
            Persona persona = new Persona();
            vConsultarVentas.txtEmpleadoNombre.setText(persona.getNombres());
        }
    }
}
