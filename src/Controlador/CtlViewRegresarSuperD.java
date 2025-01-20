/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewCatalogoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.ViewCatalogoSuperDep;

/**
 *
 * @author juanc
 */
public class CtlViewRegresarSuperD implements ActionListener{
    
    private ViewCatalogoSuperDep vcsd;
    private ViewCatalogoPrincipal vcp;

    public CtlViewRegresarSuperD(ViewCatalogoSuperDep vcsd, ViewCatalogoPrincipal vcp) {
        this.vcsd = vcsd;
        this.vcp = vcp;
        
        this.vcsd.btnVolversuper.addActionListener(this);
    }
    
   
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vcsd.btnVolversuper)){
            vcp.setVisible(true);
            vcsd.dispose();
       }


    }
    
}
