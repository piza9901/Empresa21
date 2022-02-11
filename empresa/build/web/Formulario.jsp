<%-- 
    Document   : Formulario
    Created on : 19/09/2019, 04:10:24 PM
    Author     : sebastian piza
--%>

<%@page import="modelo.Cliente"%>
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
        <div class="row justify-content">
            <main id="content" class="col-sm-12 col-md-9 offset-md-1">
                <h3 class="subtitle">Registro de clientes</h3>
                <section class="contenido-formulario">
                    <div class="container">
                        <form class="row" method="post" action="<%= request.getAttribute("url")%>">
                            <% Cliente seleccionCliente = (Cliente) request.getAttribute("CLIENTE_SELECCIONADO"); %>
                            <% if(seleccionCliente != null) { %>
                            <input type="hidden" name="idCliente" value="<%= seleccionCliente.getId() %>" class="form-control">
                            <input type="hidden" name="idPersona" value="<%= seleccionCliente.getIdPersona() %>" class="form-control">
                            <% } %>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Primer Nombre</label>
                                <input type="text" name="primerNombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Primer Nombre">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Segundo Nombre</label>
                                <input type="text" name="segundoNombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Segundo Nombre">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Primer Apellido</label>
                                <input type="text" name="primerApellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Primer Apellido">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Segundo Apellido</label>
                                <input type="text" name="segundoApellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Segundo Apellido">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleFormControlSelect2">Tipo de Documento</label>
                                <select  class="form-control" name="documento">
                                    <option value="">Seleccione un tipo de documento</option>
                                    <option value="1">Cédula de Ciudadadanía</option>
                                    <option value="2">Tarjeta de Identidad</option>
                                    <option value="3">Pasaporte</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Número de Documento</label>
                                <input type="text" name="numeroDocumento" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Número de Documento">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleFormControlSelect2">Género</label>
                                <select  class="form-control" name="genero">
                                    <option value="">Seleccione un Género</option>
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                    <option value="3">Otro</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Teléfono</label>
                                <input type="text" name="telefono" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="telefono">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Dirección</label>
                                <input type="text" name="direccion" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="direccion">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Correo Electrónico</label>
                                <input type="email" name="correo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            </div>
                            <div class="form-group col-sm-10 col-md-6 offset-lg-3">
                                <label for="exampleInputPassword1">Contraseña</label>
                                <input type="password" name="clave" class="form-control" id="exampleInputPassword1" placeholder="Password">
                            </div>

                            <div class="form-group col-sm-12">
                                <button type="submit" class="btn btn-primary">Guardar Datos</button>
                            </div>
                        </form>
                    </div>
                </section>
            </main>
        </div>


    </body>
</html>
