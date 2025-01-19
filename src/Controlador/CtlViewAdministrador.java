/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.CerrarSesion;
import Vista.ViewAdministrador;
import Vista.ViewAgregarVendedor;
import Vista.ViewConsultarVentas;
import Vista.ViewFiltrarinventario;
import Vista.ViewRegistrarMoto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class CtlViewAdministrador implements ActionListener {
    
    private ViewAdministrador vpa;
    private CerrarSesion cs;
    private ViewRegistrarMoto vrm;
    private ViewFiltrarinventario vfi;
    private ViewConsultarVentas vcv;
    private ViewAgregarVendedor vav;

    public CtlViewAdministrador(ViewAdministrador vpa, CerrarSesion cs, ViewRegistrarMoto vrm, ViewFiltrarinventario vfi, ViewConsultarVentas vcv, ViewAgregarVendedor vav) {
        this.vpa = vpa;
        this.cs = cs;
        this.vrm = vrm;
        this.vfi = vfi;
        this.vcv = vcv;
        this.vav = vav;
        
        this.vpa.btnAgregarMoto.addActionListener(this);
        this.vpa.btnVerInventario.addActionListener(this);
        this.vpa.btnConsultarVentas.addActionListener(this);
        this.vpa.btnAgregarEmpleado.addActionListener(this);
        this.vpa.btnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vpa.btnAgregarMoto)){
            vrm.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnVerInventario)){
            vfi.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnConsultarVentas)){
            vcv.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnAgregarEmpleado)){
            vav.setVisible(true);
            this.vpa.dispose();
        }
        if(ev.getSource().equals(vpa.btnCerrarSesion)){
            cs.setVisible(true);
            this.vpa.dispose();
        }
       
    }

}
