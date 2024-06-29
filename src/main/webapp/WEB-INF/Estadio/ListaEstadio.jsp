<%--
  Created by IntelliJ IDEA.
  User: rlvs_
  Date: 28/06/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.lab1020197122.beans.Estadio" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaEstadio" scope="request" type="java.util.ArrayList<com.example.lab1020197122.beans.Estadio>" />
<html>
<head>
    <title>Lista de Estadios</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="clearfix mt-3 mt-2">
        <a href="<%=request.getContextPath()%>/EstadioServlet?action=listaEstadio">
            <h1 class="float-start link-dark">Lista de Estadios</h1>
        </a>
        <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/EstadioServlet?action=nuevoEstadio">Nuevo Estadio</a>
    </div>
    <hr/>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>#</th>
            <th>Nombre</th>
            <th>Provincia</th>
            <th>Club</th>
            <th></th>
        </tr>
        <% for (Estadio estadio : listaEstadio) { %>
        <tr>
            <td><%=estadio.getId()%></td>
            <td><%=estadio.getNombre()%></td>
            <td><%=estadio.getProvincia()%></td>
            <%
                String club = new String();
                if (estadio.getClub() == null) {
                    club = "No tiene propietario";
                } else {
                    club = estadio.getClub();
                }
            %>
            <td><%=club%></td>
            <td><a class="btn btn-danger" href="<%=request.getContextPath()%>/EstadioServlet?action=eliminarEstadio&id=<%=estadio.getId()%>">Borrar</a></td>
        </tr>
        <% } %>
    </table>
    <a class="btn btn-primary" href="<%=request.getContextPath()%>">Regresar</a>
</div>
</body>
</html>