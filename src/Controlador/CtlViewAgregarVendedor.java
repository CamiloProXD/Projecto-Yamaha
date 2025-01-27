/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoPersona;
import Modelo.DaoUsuario;
import Modelo.Persona;
import Modelo.Usuario;
import Vista.ViewAgregarVendedor;
import Vista.ViewCerrarSesionAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CtlViewAgregarVendedor implements ActionListener {

    ViewCerrarSesionAdmin cs;
    ViewAgregarVendedor vav;
    DaoUsuario daousuario;
    DaoPersona daopersona;

    public CtlViewAgregarVendedor(ViewCerrarSesionAdmin cs, ViewAgregarVendedor vav, DaoUsuario daousuario, DaoPersona daopersona) {
        this.cs = cs;
        this.vav = vav;
        this.daousuario = daousuario;
        this.daopersona = daopersona;

        vav.btnAgregarVendedor.addActionListener(this);
        vav.btnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vav.btnAgregarVendedor)) {
            String nombres = vav.txtNombres.getText();
            String apellidos = vav.txtApellidos.getText();
            int id = Integer.parseInt(vav.txtCC.getText());
            String email = vav.txtEmail.getText();
            String numeroTelefonico = vav.txtNumTelefonico.getText();
            String direccion = vav.txtDireccion.getText();
            String username = vav.txtUsername.getText();
            String password = vav.txtContrasena.getText();
            Double salario = Double.parseDouble(vav.txtSalario.getText());
            int sucursal_id = Integer.parseInt(vav.txtIDSucursal.getText());

            Persona nuevaPersona = new Persona();
            nuevaPersona.setId(id);
            nuevaPersona.setNombres(nombres);
            nuevaPersona.setApellidos(apellidos);
            nuevaPersona.setEmail(email);
            nuevaPersona.setNumeroTelefonico(numeroTelefonico);
            nuevaPersona.setDireccion(direccion);

            if (daousuario.agregarPersona(nuevaPersona)) {
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setUsername(username);
                nuevoUsuario.setPassword(password);
                nuevoUsuario.setRol("Empleado");
                nuevoUsuario.setSalario(salario);
                nuevoUsuario.setId(nuevaPersona.getId());
                nuevoUsuario.setIdSede(sucursal_id);

                if (daousuario.agregar(nuevoUsuario)) {
                    mensaje("Vendedor agregado exitosamente!", "Agregar Vendedor");
                    limpiarCampos();
                } else {
                    mensaje("Error al agregar el vendedor.", "Agregar Vendedor");
                }
            } else {
                mensaje("Error al agregar la persona.", "Agregar Persona");
            }
        }
        if (ev.getSource().equals(vav.btnCerrarSesion)) {
            cs.setVisible(true);
            this.vav.dispose();
        }

    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }

    private void limpiarCampos() {
        vav.txtUsername.setText(null);
        vav.txtContrasena.setText(null);
        vav.txtSalario.setText(null);
        vav.txtApellidos.setText(null);
        vav.txtCC.setText(null);
        vav.txtDireccion.setText(null);
        vav.txtEmail.setText(null);
        vav.txtIDSucursal.setText(null);
        vav.txtNombres.setText(null);
        vav.txtNumTelefonico.setText(null);
    }

}
