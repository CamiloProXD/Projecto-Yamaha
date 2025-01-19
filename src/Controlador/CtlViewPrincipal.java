/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoUsuario;
import Modelo.Usuario;
import Vista.ViewAdministrador;
import Vista.ViewCatalogoPrincipal;
import Vista.ViewPrincipal;
import Vista.ViewVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CtlViewPrincipal implements ActionListener {

    /**
     *
     * @param ev
     */
    //vistas
    private ViewPrincipal vp;
    private ViewAdministrador vpa;
    private ViewVendedor vpv;
    private ViewCatalogoPrincipal vcp;

    private DaoUsuario dao;
    private Usuario us;

    public CtlViewPrincipal(ViewPrincipal vp, ViewAdministrador vpa, ViewVendedor vpv, ViewCatalogoPrincipal vcp, DaoUsuario dao, Usuario us) {
        this.vp = vp;
        this.vpa = vpa;
        this.vpv = vpv;
        this.vcp = vcp;
        this.dao = dao;
        this.us = us;

        this.vp.btnEntrar.addActionListener(this);
        this.vp.btnCatalogo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vp.btnEntrar)) {
            String usuario = vp.txtUsuario.getText().trim();
            String contrasena = vp.txtContrasena.getText().trim();

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                mensaje("Por favor, complete todos los campos", "Campos vacíos");
                return;
            }

            try {
              
                us.setUsername(usuario);

              
                if (dao.consultar(us)) {
                    
                    if (us.getPassword().equals(contrasena)) {
                        if (us.getRol().equalsIgnoreCase("Admin")) {
                            vpa.setVisible(true);
                            vp.dispose();
                        } else if (us.getRol().equalsIgnoreCase("Empleado")) {
                            vpv.setVisible(true);
                            vp.dispose();
                        } else {
                            mensaje("Rol no reconocido", "Error");
                            limpiar();
                        }
                    } else {
                        mensaje("Contraseña incorrecta, inténtelo nuevamente", "Error");
                        limpiar();
                    }
                } else {
                    mensaje("Usuario no encontrado", "Error");
                    limpiar();
                }
            } catch (Exception ex) {
                System.err.println("Error al consultar el usuario: " + ex.getMessage());
                mensaje("Ocurrió un error al verificar las credenciales", "Error");
            }
        }
        if(ev.getSource().equals(vp.btnCatalogo)){
            vcp.setVisible(true);
            this.vp.dispose();
        }
    }

    public void mensaje(String txt, String btn) {
        JOptionPane.showMessageDialog(null, txt, btn, 1);
    }

    public void limpiar() {
        vp.txtUsuario.setText(null);
        vp.txtContrasena.setText(null);
    }
}
