/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author grabieloX19X
 */
public class DaoPago extends Conexion {

    public boolean agregar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "insert into pagos(numero_factura, monto_pago, pagado) values(?, ?, ?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, pago.getNumeroFactura() + "");
            pst.setString(2, pago.getMontoPago() + "");
            pst.setString(3, pago.isPagado() + "");
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }
        return false;
    }

    public boolean actualizar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "update pagos set numero_factura=?, monto_pago=?, pagado=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, pago.getNumeroFactura() + "");
            pst.setString(2, pago.getMontoPago() + "");
            pst.setString(3, pago.isPagado() + "");
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el update-> " + ex);
            mensaje("Error al ejecutar el update", "actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "select * from pagos where numero_factura = ?";
        PreparedStatement pst;
        ResultSet rst;
        try{
            pst = cnx.prepareStatement(stc);
            pst.setString(1, pago.getNumeroFactura()+"");
            rst = pst.executeQuery();
            if(rst.next()){
                pago.setNumeroFactura(Integer.parseInt(rst.getString("numero_factura")));
                pago.setMontoPago(Double.parseDouble(rst.getString("monto_pago")));
                pago.setPagado(Integer.parseInt(rst.getString(stc)));
            }
            return true;
        }catch(SQLException ex){
            System.err.println("Error al ejecutar el SELECT -> "+ex);
            mensaje("Error al ejecutar el SELECT","consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "delete from pagos where numero_factura = ?";
        PreparedStatement pst;
        try{
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(pago.getNumeroFactura()));
            pst.execute();
            return true;
        }
        catch(SQLException ex){
            System.err.println("Error al ejecutar el DELETE -> "+ex);
            mensaje("Error al ejecutar el DELETE","eliminar!!!");
        }
        return false;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
