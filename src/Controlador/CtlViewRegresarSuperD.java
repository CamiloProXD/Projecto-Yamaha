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
    
    private ViewCatalogoSuperDep vsd;
    private ViewCatalogoPrincipal vcp;

    public CtlViewRegresarSuperD(ViewCatalogoSuperDep vcsd, ViewCatalogoPrincipal vcp) {
        this.vsd = vcsd;
        this.vcp = vcp;
        
        this.vsd.btnVolversuper.addActionListener(this);
    }
    
   
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vsd.btnVolversuper)){
            vcp.setVisible(true);
            vsd.dispose();
       }


    }
    
}
