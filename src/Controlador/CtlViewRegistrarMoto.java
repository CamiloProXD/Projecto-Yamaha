/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoMoto;
import Modelo.Moto;
import Vista.ViewRegistrarmoto;
import Vista.ViewCerrarSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRegistrarMoto implements ActionListener{
    private DaoMoto daoMoto;
    private ViewRegistrarmoto vx;
    private Moto moto;
    private ViewCerrarSesion vcs;

    public CtlViewRegistrarMoto(DaoMoto daoMoto, ViewRegistrarmoto vx, Moto moto, ViewCerrarSesion vcs ) {
        this.daoMoto = daoMoto;
        this.vx = vx;
        this.moto = moto;
        this.vcs = vcs;
        this.vx.btnRegistrar.addActionListener(this);
        this.vx.btnRegresar.addActionListener(this);
    }

    
    
        
    
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vx.btnRegistrar)){
            moto.setSerialMoto(vx.txtSerial.getText());
            moto.setColor(vx.txtColor.getText());
            moto.setCilindraje(Integer.parseInt(vx.txtCilindraje.getText()));
            moto.setModelo(vx.txtModelo.getText());
            moto.setPrecioUnitario(Double.parseDouble(vx.txtPrecio.getText()));
            moto.setTipoMoto(vx.txtTipo.getText());
            if(daoMoto.agregar(moto)){
                mensaje("Moto registrada exitosamente!!!!","Agregar!!!");
                limpiar();
            }else{
                mensaje("Moto NO registrada!!!!","Agregar!!!");
                limpiar();
            }
        }
        if(ev.getSource().equals(vx.btnRegresar)){
           vcs.setVisible(true);
           this.vx.dispose(); 
        }
    }
    
    public void mensaje(String msg, String tit) {
        JOptionPane.showMessageDialog(null, msg, tit, 1);
    }
    public void limpiar() {
        vx.txtCilindraje.setText(null);
        vx.txtColor.setText(null);
        vx.txtModelo.setText(null);
        vx.txtPrecio.setText(null);
        vx.txtSerial.setText(null);
        vx.txtTipo.setText(null);
    }
}
