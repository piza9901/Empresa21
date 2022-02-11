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
public class Factura {
    private int id;
    private String Cliente;
    private String Producto;
    private String cantidad;
    private int total;
    
    public Factura(int id) {
        this.id = id;
        this.Cliente = null;
        this.Producto = null;       
        this.cantidad = null;
        this.total = 0;
    }
}
