<%@ page import="com.example.lab1020197122.beans.Seleccion" %><%--
  Created by IntelliJ IDEA.
  User: rlvs_
  Date: 28/06/2024
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaSeleccion" scope="request" type="java.util.ArrayList<com.example.lab1020197122.beans.Seleccion>" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Nuevo Jugador</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Nuevo Jugador</h1>
    <form method="post" action="<%=request.getContextPath()%>/JugadorServlet?action=crearJugador">
        <div class="mb-3">
            <labe>Nombre</labe>
            <input type="text" class="form-control" name="Nombre">
        </div>
        <div class="mb-3">
            <label>Edad</label>
            <input type="text" class="form-control" name="Edad">
        </div>
        <div class="mb-3">
            <label>Posición</label>
            <input type="text" class="form-control" name="Posicion">
        </div>
        <div class="mb-3">
            <label>Club</label>
            <input type="text" class="form-control" name="Club">
        </div>
        <!--Select de selecciones-->
        <div class="mb-3">
            <label>Selección Nacional</label>
            <select class="form-select" name="Seleccion">
                <option value="0">-- Seleccione --</option>
                <% for (Seleccion seleccion : listaSeleccion) {%>
                <option value="<%=seleccion.getId()%>"><%=seleccion.getNombre()%></option>
                <%}%>
            </select>
        </div>
        <a href="<%=request.getContextPath()%>/JugadorServlet?action=listaJugador" class="btn btn-danger">Cancelar</a>
        <button type="submit" class="btn btn-primary">Registrar</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
