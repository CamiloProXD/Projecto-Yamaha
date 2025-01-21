/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoSede;
import Modelo.DaoUsuario;
import Modelo.Sede;
import Vista.ViewCerrarSesionEmpleado;
import Vista.ViewSucursalEmpleado;
import Vista.ViewVerInventarioSucursalEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CtlViewSucursalEmpleado implements ActionListener {

    private ViewSucursalEmpleado vse;
    private ViewVerInventarioSucursalEmpleado vvie;
    private ViewCerrarSesionEmpleado vcs;
    private DaoSede daosede;
    private DaoUsuario daousuario;

    private JTable Sucursales;
    private DefaultTableModel modeloTabla;

    public CtlViewSucursalEmpleado(ViewSucursalEmpleado vse, ViewVerInventarioSucursalEmpleado vvie, ViewCerrarSesionEmpleado vcs, DaoSede daosede, DaoUsuario daousuario) {
        this.vse = vse;
        this.vvie = vvie;
        this.vcs = vcs;
        this.daosede = daosede;
        this.daousuario = daousuario;

        this.vse.btnAcceder.addActionListener(this);
        this.vse.btnCerrarSesion.addActionListener(this);
        inicializarTabla();
    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Id Sucursal");
        modeloTabla.addColumn("Nombre Sucursal");
        modeloTabla.addColumn("Administrador");

        vse.tablaVerSucursales.setModel(modeloTabla);
        llenarTabla();
    }

    private void llenarTabla() {
        modeloTabla.setRowCount(0);
        DaoSede daoSede = new DaoSede();
        DaoUsuario daoUsuario = new DaoUsuario();

        for (Sede sede : daoSede.obtenerTodas()) {

            String nombreAdministrador = daoUsuario.obtenerNombrePorId(sede.getIdAdministrador());

            modeloTabla.addRow(new Object[]{
                sede.getIdSede(),
                sede.getNombreSede(),
                nombreAdministrador
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vse.btnAcceder)) {
            String idSucursalText = vse.txtIdSucursal.getText();
            if (idSucursalText.isEmpty()) {
                mensaje("Por favor, ingrese un ID de sucursal.", "ERROR");
                return;
            }
            try {
                int idSucursal = Integer.parseInt(idSucursalText);

                Sede sucursal = daosede.obtenerPorId(idSucursal);

                if (sucursal != null) {
                    CtlViewVerinventarioSucursalEmpleado ctlInventario = new CtlViewVerinventarioSucursalEmpleado(vvie, vcs, idSucursal);
                    vvie.setVisible(true);
                    vse.dispose();
                } else {
                    mensaje("La sucursal con el ID especificado no existe.", "ERROR");
                }

            } catch (NumberFormatException ex) {
                mensaje("Por favor, ingrese un número válido como ID de sucursal.", "ERROR");
            }
        }
        if (ev.getSource().equals(vse.btnCerrarSesion)) {
            vcs.setVisible(true);
            this.vse.dispose();
        }
    }
    
        public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }

}
