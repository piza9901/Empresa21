<%-- 
    Document   : clientes
    Created on : 21/09/2019, 07:13:58 PM
    Author     : sebastian piza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="css/formulario.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Clientes!</h1>
        <%@page import="modelo.Cliente, java.util.ArrayList" %>
        
        <% ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("Clinetes"); %>

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Nombres</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">TipoDoc</th>
                    <th scope="col">NúmDoc</th>
                    <th scope="col">Género</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Nombre de Usuario</th>
                    <th scope="col">Opciones</th>
                    
                </tr>
            </thead>
            <tbody>
                <% for(Cliente c: clientes) { %>
                <tr>
                    <td><%= c.getPrimerNombre() + " " + c.getSegundoNombre()%></td>
                    <td><%=  c.getPrimerApellido() + " " + c.getSegundoApellido()%></td>
                    <td><%=  c.getDocumento().getNombre() %></td>
                    <td><%= c.getNumeroDocumento()%></td>
                    <td><%= c.getGenero().getNombre()%></td>
                    <td><%= c.getCorreo()%></td>
                    <td><%= c.getTelefono()%></td>
                    <td><%= c.getNombreUsuario()%></td>
                    <td><a class="btn btn-primary" href="EditarCliente?idCliente=<%= c.getId()%>" role="button">Editar></a>
                    <a class="btn btn-danger" href="EliminarCliente?idCliente=<%= c.getId()%>" role="button">Eliminar></a></td>
                </tr>
                <% } %>
            </tbody>
        </table>

    </body>
</html>
