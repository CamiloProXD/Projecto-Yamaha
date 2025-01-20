/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewAdministrador;
import Vista.ViewAgregarVendedor;
import Vista.ViewCerrarSesionAdmin;
import Vista.ViewConsultarVentas;
import Vista.ViewRegistrarmoto;
import Vista.ViewSucursalAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class CtlViewAdministrador implements ActionListener{

    private ViewAdministrador vpa;
    private ViewRegistrarmoto vrm;
    private ViewSucursalAdministrador vs;
    private ViewConsultarVentas vcv;
    private ViewAgregarVendedor vav;
    private ViewCerrarSesionAdmin vcs;

    public CtlViewAdministrador(ViewAdministrador vpa, ViewRegistrarmoto vrm, ViewSucursalAdministrador vs, ViewConsultarVentas vcv, ViewAgregarVendedor vav, ViewCerrarSesionAdmin vcs) {
        this.vpa = vpa;
        this.vrm = vrm;
        this.vs = vs;
        this.vcv = vcv;
        this.vav = vav;
        this.vcs = vcs;
        
        vpa.btnAgregarMoto.addActionListener(this);
        vpa.btnAgregarVendedor.addActionListener(this);
        vpa.btnConsultarVentas.addActionListener(this);
        vpa.btnVerInventario.addActionListener(this);
        vpa.btnRegresaMenuPrincipal.addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vpa.btnAgregarMoto)){
            vrm.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnAgregarVendedor)){
            vav.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnVerInventario)){
            vs.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnConsultarVentas)){
            vcv.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnRegresaMenuPrincipal)){
            vcs.setVisible(true);
            this.vpa.dispose();
        }
    }
    
    
}
