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
public class Persona {
    protected int idPersona;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Documento documento;
    private Genero genero;
    private String numeroDocumento;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
        this.primerNombre = null;
        this.segundoNombre = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.documento = null;
        this.genero = null;
        this.numeroDocumento = null;    
    } 
    
    public Persona() {
        this.idPersona = 0;
        this.primerNombre = null;
        this.segundoNombre = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.documento = null;
        this.genero = null;
        this.numeroDocumento = null;    
    } 

    public int getIdPersona() {
        return idPersona;
    }

    public void setId(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    
}
