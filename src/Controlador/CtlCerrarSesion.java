package Controlador;

import Vista.CerrarSesion;
import Vista.ViewAdministrador;
import Vista.ViewPrincipal;
import Vista.ViewVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Usuario;

public class CtlCerrarSesion implements ActionListener {

    private ViewPrincipal vp;
    private ViewVendedor vuv;
    private ViewAdministrador vpa;
    private CerrarSesion cs;
    private String Rol;

    public CtlCerrarSesion(ViewPrincipal vp, ViewVendedor vuv, ViewAdministrador vpa, CerrarSesion cs, String Rol) {
        this.cs = cs;
        this.vpa = vpa;
        this.vp = vp;
        this.vuv = vuv;
        this.cs.btncerrarSesion.addActionListener(this);
        this.cs.btnSalir.addActionListener(this);
        this.cs.btnMenuPrincipal.addActionListener(this);
        this.Rol = Rol;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource().equals(cs.btncerrarSesion)) {
            vp.setVisible(true);
            this.cs.dispose();
        }
        if (ev.getSource().equals(cs.btnSalir)) {
            System.exit(0);
        }
        if (ev.getSource().equals(cs.btnMenuPrincipal)) {
            if (Rol.equals("Admin")) {
                this.vpa.setVisible(true);
                this.cs.dispose();
            }
            if (Rol.equals("Empleado")) {
                this.vuv.setVisible(true);
                this.cs.dispose();              
            }
        }
    }
}
