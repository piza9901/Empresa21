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
public class Usuario extends Persona{
    private int id;
    private String nombreUsuario;
    private String correo;
    private String clave;
    
    public Usuario(int id, int idPersona) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombreUsuario = null;
        this.correo = null;
        this.clave = null;
    }
    
    public Usuario() {
        this.id = 0;
        this.idPersona = 0;
        this.nombreUsuario = null;
        this.correo = null;
        this.clave = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
}
