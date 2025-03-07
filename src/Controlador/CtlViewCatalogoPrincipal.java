/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewCatalogoPrincipal;
import Vista.ViewCatalogoDeportivas;
import Vista.ViewCatalogoSuperDep;
import Vista.ViewCatalogoAutomaticas;
import Vista.ViewCatalogoCross;
import Vista.ViewCatalogoUrbanas;
import Vista.ViewCatalogoTodoterreno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.ViewPrincipal;


public class CtlViewCatalogoPrincipal implements ActionListener {
    private ViewCatalogoPrincipal vcp; 
    private ViewCatalogoDeportivas vcd; 
    private ViewCatalogoSuperDep vsd; 
    private ViewCatalogoAutomaticas ca; 
    private ViewCatalogoCross cc; 
    private ViewCatalogoUrbanas vcu; 
    private ViewCatalogoTodoterreno ctt; 
    private ViewPrincipal vp;
    

    public CtlViewCatalogoPrincipal(ViewCatalogoPrincipal vcp, ViewCatalogoDeportivas vcd, ViewCatalogoSuperDep vsd, ViewCatalogoAutomaticas ca, ViewCatalogoCross cc, ViewCatalogoUrbanas vcu, ViewCatalogoTodoterreno ctt, ViewPrincipal vp) {
        this.vcp = vcp;
        this.vcd = vcd;
        this.vsd = vsd;
        this.ca = ca;
        this.cc = cc;
        this.vcu = vcu;
        this.ctt = ctt;
        this.vp = vp;
        
        this.vcp.btnDeportivas.addActionListener(this);
        this.vcp.btnSuperDeportivas.addActionListener(this);
        this.vcp.btnAutomaticas.addActionListener(this);
        this.vcp.btnEnduro.addActionListener(this);
        this.vcp.btnUrbanasYtrabajo.addActionListener(this);
        this.vcp.btnTodoterreno.addActionListener(this);
        this.vcp.btnVolver1.addActionListener(this); 
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vcp.btnDeportivas)) {
            vcd.setVisible(true);
            vcp.dispose(); 
        } else if (ev.getSource().equals(vcp.btnSuperDeportivas)) {
            vsd.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnAutomaticas)) {
            ca.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnEnduro)) {
            cc.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnUrbanasYtrabajo)) {
            vcu.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnTodoterreno)) {
            ctt.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnVolver1)) {
            vp.setVisible(true); 
            vcp.dispose();    
        
        }
    }
}