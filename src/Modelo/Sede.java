/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Sede {
    private int idSede;
    private int inventario_id;
    private String nombreSede;
    private String municipio;
    private int idAdministrador;

    public Sede(int idSede, int inventario_id, String nombreSede, String municipio, int idAdministrador) {
        this.idSede = idSede;
        this.inventario_id = inventario_id;
        this.nombreSede = nombreSede;
        this.municipio = municipio;
        this.idAdministrador = idAdministrador;
    }

    public Sede() {
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public int getInventario_id() {
        return inventario_id;
    }

    public void setInventario_id(int inventario_id) {
        this.inventario_id = inventario_id;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    
  
}
