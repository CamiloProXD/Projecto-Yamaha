package Controlador;

import Vista.ViewCerrarSesionAdmin;
import Vista.ViewAdministrador;
import Vista.ViewPrincipal;
import Vista.ViewVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlViewCerrarSesionEmpleado implements ActionListener {

    private ViewPrincipal vp;
    private ViewVendedor vpv;
    private ViewCerrarSesionAdmin cs;

    public CtlViewCerrarSesionEmpleado(ViewPrincipal vp, ViewVendedor vpa, ViewCerrarSesionAdmin cs) {
        this.cs = cs;
        this.vpv = vpa;
        this.vp = vp;
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

            this.vpv.setVisible(true);
            this.cs.dispose();

        }
    }
}
