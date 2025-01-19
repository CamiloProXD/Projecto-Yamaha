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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DaoVenta extends Conexion {

    public boolean agregar(Venta v) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO ventas (numero_factura, fecha, vendedor_id, cliente_id) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(v.getNumeroFactura()));
            pst.setDate(2, new java.sql.Date(v.getFecha().getTime()));
            pst.setString(3, Integer.toString(v.getVendedor().getIdUsuario()));
            pst.setString(4, Integer.toString(v.getCliente().getIdUsuario()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }

    public boolean actualizar(Venta v) {
        Connection cnx = getConexion();
        String stc = "UPDATE ventas SET fecha=?, vendedor_id=?, cliente_id=? WHERE numero_factura=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setDate(1, new java.sql.Date(v.getFecha().getTime()));
            pst.setString(2, Integer.toString(v.getVendedor().getIdUsuario()));
            pst.setString(3, Integer.toString(v.getCliente().getIdUsuario()));
            pst.setString(4, Integer.toString(v.getNumeroFactura()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }

    public Venta consultar(Venta v) {
        Connection cnx = getConexion();
        String stcVenta = "SELECT v.fecha, v.vendedor_id, v.cliente_id FROM ventas v WHERE v.numero_factura = ?";
        String stcMotos = "SELECT vm.moto_id FROM ventas_motos vm WHERE vm.venta_id = ?";
        PreparedStatement pstVenta, pstMotos;
        ResultSet rstVenta, rstMotos;
        try {
            pstVenta = cnx.prepareStatement(stcVenta);
            pstVenta.setString(1, Integer.toString(v.getNumeroFactura()));
            rstVenta = pstVenta.executeQuery();
            if (rstVenta.next()) {

                Venta venta = new Venta();
                venta.setNumeroFactura(v.getNumeroFactura());
                venta.setFecha(new Date(rstVenta.getDate("fecha").getTime()));

                Usuario vendedor = new Usuario();
                vendedor.setIdUsuario(rstVenta.getInt("vendedor_id"));
                venta.setVendedor(vendedor);

                Usuario cliente = new Usuario();
                cliente.setIdUsuario(rstVenta.getInt("cliente_id"));
                venta.setCliente(cliente);

                List<Moto> motos = new ArrayList<>();
                pstMotos = cnx.prepareStatement(stcMotos);
                pstMotos.setInt(1, v.getNumeroFactura());
                rstMotos = pstMotos.executeQuery();
                while (rstMotos.next()) {
                    Moto moto = new Moto();
                    moto.setSerialMoto(rstMotos.getString("moto_id"));
                    motos.add(moto);
                }
                venta.setMotosVenta(motos);

                return venta;

            }

        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return null;
    }

    public boolean eliminar(Venta v) {
        Connection cnx = getConexion();
        String stcEliminarMotos = "DELETE FROM ventas_motos WHERE venta_id = ?";
        String stcEliminarVenta = "DELETE FROM ventas WHERE numero_factura = ?";
        PreparedStatement pstEliminarMotos, pstEliminarVenta;
        try {
            pstEliminarMotos = cnx.prepareStatement(stcEliminarMotos);
            pstEliminarMotos.setInt(1, v.getNumeroFactura());
            pstEliminarMotos.executeUpdate();

            pstEliminarVenta = cnx.prepareStatement(stcEliminarVenta);
            pstEliminarVenta.setInt(1, v.getNumeroFactura());
            pstEliminarVenta.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
