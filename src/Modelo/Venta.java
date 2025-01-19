package Modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Venta {
    private int numero_factura;
    private Date fecha;
    private Usuario cliente;
    private Usuario vendedor;
    private List<Moto> motosVenta;

    public Venta(int numeroFactura, Date fecha, Usuario quienCompro, Usuario quienAtendio, List<Moto> motosVenta) {
        this.numero_factura = numeroFactura;
        this.fecha = fecha;
        this.cliente = quienCompro;
        this.vendedor = quienAtendio;
        this.motosVenta = motosVenta;
    }

    public Venta() {
    }

    public int getNumeroFactura() {
        return numero_factura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numero_factura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public List<Moto> getMotosVenta() {
        return motosVenta;
    }

    public void setMotosVenta(List<Moto> motosVenta) {
        this.motosVenta = motosVenta;
    }

    public void agregarMoto(Moto moto) {
        this.motosVenta.add(moto);
    }

    public void eliminarMoto(Moto moto) {
        this.motosVenta.remove(moto);
    }
}
