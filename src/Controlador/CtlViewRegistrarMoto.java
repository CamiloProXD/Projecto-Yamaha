/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoMoto;
import Modelo.Moto;
import Vista.ViewRegistrarmoto;
import Vista.ViewCerrarSesionAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRegistrarMoto implements ActionListener {

    private DaoMoto daoMoto;
    private ViewRegistrarmoto vx;
    private Moto moto;
    private ViewCerrarSesionAdmin vcs;

    public CtlViewRegistrarMoto(DaoMoto daoMoto, ViewRegistrarmoto vx, Moto moto, ViewCerrarSesionAdmin vcs) {
        this.daoMoto = daoMoto;
        this.vx = vx;
        this.moto = moto;
        this.vcs = vcs;
        this.vx.btnRegistrar.addActionListener(this);
        this.vx.btnRegresar.addActionListener(this);
        this.vx.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vx.btnRegistrar)) {
            moto.setSerialMoto(vx.txtSerial.getText());
            moto.setColor(vx.txtColor.getText());
            moto.setCilindraje(Integer.parseInt(vx.txtCilindraje.getText()));
            moto.setModelo(vx.txtModelo.getText());
            moto.setPrecioUnitario(Double.parseDouble(vx.txtPrecio.getText()));
            String tipoSeleccionado = (String) vx.cbTipoMoto.getSelectedItem();
            moto.setTipoMoto(tipoSeleccionado);
            if (tipoSeleccionado != null) {
                moto.setTipoMoto(tipoSeleccionado);
            } else {
                System.out.println("Por favor, selecciona un tipo de moto.");
            }
            moto.setSedeId(Integer.parseInt(vx.txtSucursal.getText()));
            moto.setNombre(vx.txtNombre.getText());
            if (daoMoto.agregar(moto)) {
                mensaje("Moto registrada exitosamente!!!!", "Agregar!!!");
                limpiar();
            } else {
                mensaje("Moto NO registrada!!!!", "Agregar!!!");
                limpiar();
            }
        }
        if (ev.getSource().equals(vx.btnRegresar)) {
            vcs.setVisible(true);
            this.vx.dispose();
        }
        if (ev.getSource().equals(vx.btnActualizar)) {

            moto.setSerialMoto(vx.txtSerial.getText());
            moto.setColor(vx.txtColor.getText());
            moto.setCilindraje(Integer.parseInt(vx.txtCilindraje.getText()));
            moto.setModelo(vx.txtModelo.getText());
            moto.setPrecioUnitario(Double.parseDouble(vx.txtPrecio.getText()));
            String tipoSeleccionado = (String) vx.cbTipoMoto.getSelectedItem();
            moto.setTipoMoto(tipoSeleccionado);
            if (tipoSeleccionado != null) {
                moto.setTipoMoto(tipoSeleccionado);
            } else {
                System.out.println("Por favor, selecciona un tipo de moto.");
            }
            moto.setSedeId(Integer.parseInt(vx.txtSucursal.getText()));
            moto.setNombre(vx.txtNombre.getText());

            if (daoMoto.actualizar(moto)) {
                mensaje("Moto actualizada exitosamente!!!!", "Actualizar!!!");
                limpiar();
            } else {
                mensaje("Moto NO actualizada!!!!", "Actualizar!!!");
                limpiar();
            }
        }
    }

    public void mensaje(String msg, String tit) {
        JOptionPane.showMessageDialog(null, msg, tit, 1);
    }

    public void limpiar() {
        vx.txtCilindraje.setText(null);
        vx.txtColor.setText(null);
        vx.txtModelo.setText(null);
        vx.txtPrecio.setText(null);
        vx.txtSerial.setText(null);
        vx.txtNombre.setText(null);
        vx.txtSucursal.setText(null);
    }
}
