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
import Vista.ViewCatalogoTodoTer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlViewCatalogoPrincipal implements ActionListener {
    private ViewCatalogoPrincipal vcp;

    public CtlViewCatalogoPrincipal(ViewCatalogoPrincipal vcp) {
        this.vcp = vcp;
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
            ViewCatalogoDeportivas vcd = new ViewCatalogoDeportivas();
            vcd.setVisible(true);
            vcp.dispose();             
        } else if (ev.getSource().equals(vcp.btnSuperDeportivas)) {
            ViewCatalogoSuperDep vsd = new ViewCatalogoSuperDep();
            vsd.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnAutomaticas)) {
            ViewCatalogoAutomaticas ca = new ViewCatalogoAutomaticas();
            ca.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnEnduro)) {
            ViewCatalogoCross cc = new ViewCatalogoCross();
            cc.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnUrbanasYtrabajo)) {
            ViewCatalogoUrbanas vcu = new ViewCatalogoUrbanas();
            vcu.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnTodoterreno)) {
            ViewCatalogoTodoTer ctt = new ViewCatalogoTodoTer();
            ctt.setVisible(true);
            vcp.dispose();
        } else if (ev.getSource().equals(vcp.btnVolver1)) {
            
        }
    }
}