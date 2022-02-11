<%-- 
    Document   : index
    Created on : 12/09/2019, 03:43:46 PM
    Author     : sebastian piza
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <head>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link href="css/estilo.css" type="text/css" rel="stylesheet">
        <link href="css/menu.css" type="text/css" rel="stylesheet"> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title> motor art </title>
    </head>

    <style>
        h1{
            font-family: sans-serif;
            font-size: 1.5em;
            color:black;
            text-align:left;
        }
        p{
            font-family: serif;
            font-size: 14pt;
            color:(white);
            /*color:#000ff;*/
            text-align-last: center;

        }
        body{
            /*bakgraund-color:black;*/
            background: url(imagenes/fondo-negro-199872.jpg)no-repeat;
            background-size: 100vw 100vh;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-color: purple;
            color: white;  
        }


    </style>

    <body>
        <header class="row" im src="img/motor%20art.jpg" width="600" height="300">
            <!-- <section 1d="1"></section> -->

            <section class="col-sm-12 col-md-9">
                <h2 align="center"><i>motor art</i></h2>
            </section>

            <section class="col-sm-12 col-md-3" align="right">
                <form class="form-inline " method="post" action="Login">
                    <% Usuario usuario = (Usuario)session.getAttribute("USUARIO");
                    if(usuario == null) { %>
                    <label class="sr-only" for="inlineFormInputGroupUsername2">usuario</label>
                    <div class="input-group mb-2 mr-sm-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">@</div>
                        </div>
                        <input type="text" class="form-control" id="inlineFormInputGroupUsername2" name="nombreUsuario" placeholder="Username">
                    </div>
                        <label class="sr-only" for="inlineFormInputName2">Contraseña</label>
                        <input type="password" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2" name="clave" placeholder="      ">
                    <div class="form-check mb-2 mr-sm-2">
                        <input class="form-check-input" type="checkbox" id="inlineFormCheck">
                        <label class="form-check-label" for="inlineFormCheck">
                            recuerdame
                        </label>
                    </div>

                    <button type="submit" name="entrar" class="btn btn-primary mb-2">entrar</button>
                    <% } %>
                </form>
            </section>
        </header>   


        <nav class="navbar navbar-expand-lg navbar-white bg-white" class"">
             <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        
                        <a class="nav-link" href="index.jsp">inicio <span class="sr-only">(current)</span></a>
                    
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> noticias</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="helcat.jsp"target="principal">Dodge Charger ’68 Hellephant</a>
                            <a class="dropdown-item" href="lincon.jsp"target="principal">lincon navigaitor</a>
                            <div class="dropdown-divider"></div>

                        </div>
                    </li>
                    <% if (usuario != null) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="compras.jsp" target="principal">Compras <span class="sr-only">(current)</span></a>
                    </li>
                    <% } %>
                    <li class="nav-item">
                        <a class="nav-link" href="mapa.jsp" target="principal">contacto</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Formulario.jsp">Registrame <span class="sr-only">(current)</span></a>
                    </li>
                </ul>

                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>  
        </nav>

        <div class="clearfix"></div>
        <aside id= "derecha"><img src="imagenes/huellas-neumaticos-sucios-perdiendose-horizonte_1017-8084.jpg" width="400"height="501"></aside>
        <main>  
            <iframe src="imagenes/fondo-negro-199872.jpg" name="principal" width="683" height="497">  
            </iframe> 
        </main>

        <aside id= "izquierda"><img src="imagenes/luces-traseras-coche_2221-186.jpg"  width="307"height="500"></aside>
        <footer src="img/coches.jpg"> 

        </footer>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

        <script src="js/bootstrap.js" crossorigin="anonymous"></script>

    </body>
</html>