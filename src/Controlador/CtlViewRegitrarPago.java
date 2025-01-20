/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewCerrarSesion;
import Vista.ViewRegistrarpago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRegitrarPago implements ActionListener{
    
    private ViewRegistrarpago vrp;
    private ViewCerrarSesion vcs;

    public CtlViewRegitrarPago(ViewRegistrarpago vrp, ViewCerrarSesion vcs) {
        this.vrp = vrp;
        this.vcs = vcs;
        vrp.btnConfirmarpago.addActionListener(this);
        vrp.btnRegresar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vrp)){
            JOptionPane.showMessageDialog(null, "pago "+ vrp.txtNumfactura + " registrado exitosamente", "confirmacion registro pago", 4);
        }
    }
}
