<%--
  Created by IntelliJ IDEA.
  User: rlvs_
  Date: 28/06/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.lab1020197122.beans.Jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaJugador" scope="request" type="java.util.ArrayList<com.example.lab1020197122.beans.Jugador>" />
<html>
<head>
    <title>Lista de jugadores</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="clearfix mt-3 mt-2">
        <a href="<%=request.getContextPath()%>/JugadorServlet?action=listaJugador">
            <h1 class="float-start link-dark">Lista de Jugadores</h1>
        </a>
        <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/JugadorServlet?action=nuevoJugador">Nuevo Jugador</a>
    </div>
    <hr/>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>#</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Posición</th>
            <th>Club</th>
            <th>Selección</th>
            <th></th>
        </tr>
        <% for (Jugador jugador : listaJugador) { %>
        <tr>
            <td><%=jugador.getId()%></td>
            <td><%=jugador.getNombre()%></td>
            <td><%=jugador.getEdad()%></td>
            <td><%=jugador.getPosicion()%></td>
            <td><%=jugador.getClub()%></td>
            <td><%=jugador.getSeleccion().getNombre()%></td>
            <td><a class="btn btn-danger" href="<%=request.getContextPath()%>/JugadorServlet?action=eliminarJugador&id=<%=jugador.getId()%>">Borrar</a></td>
        </tr>
        <% } %>
    </table>
    <a class="btn btn-primary" href="<%=request.getContextPath()%>">Regresar</a>
</div>
</body>
</html>