/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Documento;
import modelo.Genero;

/**
 *
 * @author sebastian piza
 */
@WebServlet(name = "RegistroClientesControlador", urlPatterns = {"/RegistroClientes"})
public class RegistroClientesControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        
        System.out.println("hello man 9");
        String primerNombre = request.getParameter("primerNombre");
        String segundoNombre = request.getParameter("segundoNombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        int documentoId = Integer.parseInt(request.getParameter("documento"));
        String numeroDocumento = request.getParameter("numeroDocumento");
        int generoId = Integer.parseInt(request.getParameter("genero"));
        String correo = request.getParameter("correo");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String clave = request.getParameter("clave");
        System.out.println("hello man 10");
        
        Documento documento = new Documento(documentoId);
        Genero genero = new Genero(generoId);
        
        System.out.println("hello man 11");
        cliente.setPrimerNombre(primerNombre);
        cliente.setSegundoNombre(segundoNombre);
        cliente.setPrimerApellido(primerApellido);
        cliente.setSegundoApellido(segundoApellido);
        cliente.setDocumento(documento);
        cliente.setNumeroDocumento(numeroDocumento);
        cliente.setGenero(genero);
        cliente.setCorreo(correo);
        cliente.setNombreUsuario(nombreUsuario);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setClave(clave);
        System.out.println("hello man 12");
        
        ClienteDao clienteDao = new ClienteDao();
        
        clienteDao.registrarCliente(cliente);
        
        response.sendRedirect("index.jsp");
    }

 
}
