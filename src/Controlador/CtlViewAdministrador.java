/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewAdministrador;
import Vista.ViewAgregarVendedor;
import Vista.ViewCerrarSesion;
import Vista.ViewConsultarVentas;
import Vista.ViewFiltrarinventario;
import Vista.ViewRegistrarmoto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class CtlViewAdministrador implements ActionListener{

    private ViewAdministrador vpa;
    private ViewRegistrarmoto vrm;
    private ViewFiltrarinventario vfi;
    private ViewConsultarVentas vcv;
    private ViewAgregarVendedor vav;
    private ViewCerrarSesion vcs;

    public CtlViewAdministrador(ViewAdministrador vpa, ViewRegistrarmoto vrm, ViewFiltrarinventario vfi, ViewConsultarVentas vcv, ViewAgregarVendedor vav, ViewCerrarSesion vcs) {
        this.vpa = vpa;
        this.vrm = vrm;
        this.vfi = vfi;
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
            vfi.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnConsultarVentas)){
            vrm.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnRegresaMenuPrincipal)){
            vrm.setVisible(true);
            this.vpa.dispose();
        }
    }
    
    
}
