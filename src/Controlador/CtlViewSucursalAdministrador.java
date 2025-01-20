/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewSucursalAdministrador;
import Modelo.DaoSede;
import Modelo.DaoUsuario;
import Modelo.Sede;
import Vista.ViewCerrarSesionAdmin;
import Vista.ViewVerInventarioSucursalAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CtlViewSucursalAdministrador implements ActionListener {

    private ViewSucursalAdministrador vsa;
    private ViewVerInventarioSucursalAdmin vvisa;
    private ViewCerrarSesionAdmin vcs;
    private DaoSede daosede;
    private DaoUsuario daousuario;

    private JTable Sucursales;
    private DefaultTableModel modeloTabla;

    public CtlViewSucursalAdministrador(ViewSucursalAdministrador vsa, ViewVerInventarioSucursalAdmin vvisa, ViewCerrarSesionAdmin vcs, DaoSede daosede, DaoUsuario daousuarios) {
        this.vsa = vsa;
        this.vvisa = vvisa;
        this.vcs = vcs;
        this.daosede = daosede;
        this.daousuario = daousuario;

        this.vsa.btnAcceder.addActionListener(this);
        this.vsa.btnCerrarSesion.addActionListener(this);
        inicializarTabla();

    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Id Sucursal");
        modeloTabla.addColumn("Nombre Sucursal");
        modeloTabla.addColumn("Administrador");

        vsa.tablaVerSucursales.setModel(modeloTabla);
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
        if (ev.getSource().equals(vsa.btnAcceder)) {
            String idSucursalText = vsa.txtIdSucursal.getText();
            if (idSucursalText.isEmpty()) {
                mensaje("Por favor, ingrese un ID de sucursal.", "ERROR");
                return;
            }
            try {
                int idSucursal = Integer.parseInt(idSucursalText);

                Sede sucursal = daosede.obtenerPorId(idSucursal);

                if (sucursal != null) {
                    CtlViewVerInventarioSucursalAdmin ctlInventario = new CtlViewVerInventarioSucursalAdmin(vvisa, idSucursal);
                    vvisa.setVisible(true);
                    vsa.dispose();
                } else {
                    mensaje("La sucursal con el ID especificado no existe.", "ERROR");
                }

            } catch (NumberFormatException ex) {
                mensaje("Por favor, ingrese un número válido como ID de sucursal.", "ERROR");
            }
        }

        if (ev.getSource().equals(vsa.btnCerrarSesion)) {
            vcs.setVisible(true);
            this.vsa.dispose();
        }
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }

}
