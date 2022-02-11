/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDao;
import dao.PersonaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 *
 * @author sebastian piza
 */
@WebServlet(name = "EliminarClienteControlador", urlPatterns = {"/EliminarCliente"})
public class EliminarClienteControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        ClienteDao clienteDao = new ClienteDao();
        Cliente c = clienteDao.getCliente(idCliente);
        clienteDao.eliminarCliente(c);
        
        PersonaDao personaDao = new PersonaDao();
        personaDao.eliminarPersona(c);
        
        response.sendRedirect("index.jsp");
        
        
    }

}
