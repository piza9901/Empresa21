/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import dao.ClienteDao;
import modelo.Cliente;
import modelo.Genero;
import modelo.Documento;

/**
 *
 * @author Luisk
 */
@WebServlet(name = "EditarClientesControlador", urlPatterns = {"/EditarClientesControlador"})
public class EditarClientesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("hello man");
            request.setAttribute("url", "EditarClientes");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            ClienteDao clienteDao = new ClienteDao();
            Cliente c = clienteDao.getCliente(idCliente);
            request.setAttribute("CLIENTE_SELECCIONADO", c);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientes.jsp");
            dispatcher.forward(request, response);
            System.out.println("hello man");
        }
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("index.jsp");
        } else {

            System.out.println("quiero entrar");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idPersona = Integer.parseInt(request.getParameter("idPersona"));
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            int documentoId = Integer.parseInt(request.getParameter("documento"));
            String numeroDocumnto = request.getParameter("numeroDocumento");
            int generoId = Integer.parseInt(request.getParameter("genero"));
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String nombreUsuario = request.getParameter("nombreUsuario");
            String clave = request.getParameter("clave");


            System.out.println("estoy dentro");
            Cliente cliente = new Cliente();
            Genero g = new Genero(generoId);
            Documento documento = new Documento(documentoId);
            cliente.setIdPersona(idPersona);
            cliente.setId(idCliente);
            cliente.setPrimerNombre(primerNombre);
            cliente.setSegundoNombre(segundoNombre);
            cliente.setPrimerApellido(primerApellido);
            cliente.setSegundoApellido(segundoApellido);
            cliente.setDocumento(documento);
            cliente.setGenero(g);
            cliente.setNumeroDocumento(numeroDocumnto);
            cliente.setTelefono(telefono);
            cliente.setDireccion(direccion);
            cliente.setCorreo(correo);
            cliente.setNombreUsuario(nombreUsuario);
            cliente.setClave(clave);

            System.out.println("voy llegando");
            ClienteDao clienteDao = new ClienteDao();
            clienteDao.editarCliente(cliente);

            System.out.println("terminé");

            response.sendRedirect("listarUsuarios");
        }
    }

}
