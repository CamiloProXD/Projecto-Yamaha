/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoInventario;
import Vista.ViewCerrarSesionEmpleado;
import Vista.ViewVerInventarioSucursalEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CtlViewVerinventarioSucursalEmpleado implements ActionListener{
    
    private ViewVerInventarioSucursalEmpleado vvise;
    private DaoInventario daoInventario;
    private int idSucursal;
    private ViewCerrarSesionEmpleado vcs;
    private DefaultTableModel modeloTabla;

    public CtlViewVerinventarioSucursalEmpleado(ViewVerInventarioSucursalEmpleado vvise,  ViewCerrarSesionEmpleado vcs, int idSucursal) {
        this.vvise = vvise;
        this.daoInventario = new DaoInventario();
        this.idSucursal = idSucursal;
        this.vcs = vcs;
        this.vvise.btnCerrarSesion.addActionListener(this);
        
        inicializarTabla();
        cargarInventario();
    }
    
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Cantidad");

        vvise.tablaInventarioSucursal.setModel(modeloTabla);
    }

    private void cargarInventario() {
        modeloTabla.setRowCount(0);

        List<Object[]> inventario = daoInventario.obtenerInventarioPorSucursal(idSucursal);

        if (inventario.isEmpty()) {

        } else {

            for (Object[] fila : inventario) {
                modeloTabla.addRow(fila);
            }
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vvise.btnCerrarSesion)) {
            vcs.setVisible(true);
            this.vvise.dispose();
        }
    }
    
    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
    
}
