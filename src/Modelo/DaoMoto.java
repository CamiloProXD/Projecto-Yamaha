/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DaoMoto extends Conexion {

    public boolean agregar(Moto m) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO motos (serial_moto,color_moto,cilindraje,modelo,precio_unitario,tipo_moto,sucursal_id,nombre) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, m.getSerialMoto());
            pst.setString(2, m.getColor());
            pst.setString(3, Integer.toString(m.getCilindraje()));
            pst.setString(4, m.getModelo());
            pst.setString(5, Double.toString(m.getPrecioUnitario()));
            pst.setString(6, m.getTipoMoto());
            pst.setInt(7, m.getSedeId());
            pst.setString(8, m.getNombre());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }

    public boolean actualizar(Moto m) {
        Connection cnx = getConexion();
        String stc = "UPDATE motos SET color_moto=?,cilindraje=?,modelo=?,precio_unitario=?,tipo_moto=?, sucursal_id,nombre WHERE serial_moto=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, m.getColor());
            pst.setString(2, Integer.toString(m.getCilindraje()));
            pst.setString(3, m.getModelo());
            pst.setString(4, Double.toString(m.getPrecioUnitario()));
            pst.setString(5, m.getTipoMoto());
            pst.setString(6, m.getSerialMoto());
            pst.setInt(7, m.getSedeId());
            pst.setString(8, m.getNombre());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }
    
    public boolean actualizarVenderMoto(Moto m){
        Connection cnx = getConexion();
        String stc = "update motos set vendida = true where serial_moto = ?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, m.getSerialMoto());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE: " + ex + " stc");
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Moto m) {
        int h =0;
        Connection cnx = getConexion();
        String stc = "SELECT * FROM motos WHERE serial_moto=?";
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, m.getSerialMoto());
            rst = pst.executeQuery();
            if (rst.next()) {
                m.setColor(rst.getString("color_moto"));
                m.setCilindraje(Integer.parseInt(rst.getString("cilindraje")));
                m.setModelo(rst.getString("modelo"));
                m.setPrecioUnitario(Double.parseDouble(rst.getString("precio_unitario")));
                m.setTipoMoto(rst.getString("tipo_moto"));
                m.setSedeId(rst.getInt("sucursal_id"));
                m.setNombre(rst.getString("nombre"));

            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Moto m) {
        Connection cnx = getConexion();
        String stc = "DELETE FROM motos WHERE serial_moto=?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, (m.getSerialMoto()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }
    
     public List<Moto> obtenerPorSucursal(int idSucursal) {
        Connection cnx = getConexion();
        String stc = "SELECT nombre, modelo, color_moto, cantidad FROM motos WHERE sucursal_id = ?";
        PreparedStatement pst;
        ResultSet rst;
        List<Moto> motos = new ArrayList<>();

        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, idSucursal);
            rst = pst.executeQuery();

            while (rst.next()) {
                Moto moto = new Moto();
                moto.setNombre(rst.getString("nombre"));
                moto.setModelo(rst.getString("modelo"));
                moto.setColor(rst.getString("color_moto"));

                motos.add(moto); 
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex.getMessage());
        }

        return motos;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
