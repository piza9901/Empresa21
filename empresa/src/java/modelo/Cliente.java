/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sebastian piza
 */
public class Cliente extends Persona{

    private int id;
    private String correo;
    private String nombreUsuario;
    private String direccion;
    private String telefono;
    private String clave;
    

    public Cliente(int id, int idPersona) {
        this.id = id;
        this.correo = null;
        this.nombreUsuario = null;
        this.direccion = null;
        this.telefono = null;
        this.idPersona = idPersona;
        this.clave = null;
    }
    
    public Cliente() {
        this.id = 0;
        this.correo = null;
        this.nombreUsuario = null;
        this.direccion = null;
        this.telefono = null;
        this.idPersona = 0;
        this.clave = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    

}
