<%@page import="com.sv.udb.controlador.LugaAcceCtrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>GUIA3_POO2_GERSONMENDOZA</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    
    <body>
    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">GUIA3_POO2_GERSONMENDOZA</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
                        <a href="lugar.jsp"><i class="fa fa-fw fa-dashboard"></i> Lugar de acceso</a>
                        <a href="documento.jsp"><i class="fa fa-fw fa-dashboard"></i> Tipo documento</a>
                        <a href="gafete.jsp"><i class="fa fa-fw fa-dashboard"></i> Tipo gafete</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Personas
                            <small>Mantenimiento</small>
                        </h1>
                        <h1>${mensAler}</h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Inicio</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-file"></i> Lugar de acceso
                            </li>
                        </ol>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-12">
                        <form role="form" name="lugaBton" method="POST" action="LugaAcceServ">
                            <div class="form-group">
                                <label>Nombre lugar de acceso</label>
                                <input class="form-control" type="hidden" name="codiLugaAcce" value="${CodiLuga}">
                                <input class="form-control" type="text" name="nombLugaAcce" value="${nombLuga}" required>
                            </div>
                            <input type="submit" name="lugaBton" value="Guardar" class="btn btn-primary"/>
                            <input type="submit" name="lugaBton" value="Modificar" class="btn btn-primary"/>
                            <input type="submit" name="lugaBton" value="Eliminar" class="btn btn-primary"/>
                        </form>
                    </div>
                </div>
                        <br>
                <div class="row" id="table" >
                <form method="POST" name="Frm" action="LugaAcceServ">
                    <% request.setAttribute( "demoAttr", new LugaAcceCtrl().ConsTodo()); %>
                <display:table id="Persona" name="demoAttr" class="table table-hover">
                    <display:column property="nombLugaAcce" title="Nombres" sortable="true"/>
                    <display:column property="esta" title="Estado" sortable="true"/>
                    <display:column title="Seleccionar" sortable="true">
                        <input type="radio" name="codiPersRadio" id="${Persona.codiLugaAcce}" value="${Persona.codiLugaAcce}"/><label for="${Persona.codiLugaAcce}"></label>
                    </display:column>
                </display:table>
                        <input type="submit" name="lugaBton" value="Consultar" class="btn btn-primary"/>
                </form>
            </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    </body>

</html>

