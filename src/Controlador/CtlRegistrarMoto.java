/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoMoto;
import Modelo.Moto;
import Vista.ViewRegistrarMoto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlRegistrarMoto implements ActionListener{
    private DaoMoto daoMoto;
    private ViewRegistrarMoto vx;
    private Moto moto;

    public CtlRegistrarMoto(DaoMoto dMoto, ViewRegistrarMoto vx, Moto moto) {
        this.daoMoto = dMoto;
        this.vx = vx;
        this.moto = moto;
        this.vx.btnRegistrar.addActionListener(this);
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
