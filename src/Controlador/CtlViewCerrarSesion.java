package Controlador;

import Vista.ViewCerrarSesion;
import Vista.ViewAdministrador;
import Vista.ViewPrincipal;
import Vista.ViewVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Usuario;

public class CtlViewCerrarSesion implements ActionListener {

    private ViewPrincipal vp;
    private ViewVendedor vuv;
    private ViewAdministrador vpa;
    private ViewCerrarSesion cs;

    public CtlViewCerrarSesion(ViewPrincipal vp, ViewVendedor vuv, ViewAdministrador vpa, ViewCerrarSesion cs) {
        this.cs = cs;
        this.vpa = vpa;
        this.vp = vp;
        this.vuv = vuv;
        this.cs.btncerrarSesion.addActionListener(this);
        this.cs.btnSalir.addActionListener(this);
        this.cs.btnMenuPrincipal.addActionListener(this);
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
            
            //if (Rol.equals("Admin")) {
            //   this.vpa.setVisible(true);
            //    this.cs.dispose();
            //}
            //if (Rol.equals("Empleado")) {
            //    this.vuv.setVisible(true);
            //    this.cs.dispose();              
            //}
        }
    }
}
