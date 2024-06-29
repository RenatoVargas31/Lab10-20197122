<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        p {
            color: #666;
        }
    </style>
</head>
<body>
<h1>Bienvenido a nuestra aplicación de administración de jugadores y estadios</h1>
<p>En esta plataforma, podrás gestionar de manera eficiente toda la información relacionada con tus jugadores favoritos y los estadios donde se llevan a cabo los emocionantes encuentros.</p>
<p>¿Qué puedes hacer con nuestra aplicación?</p>
<ul>
    <li>Registrar y eliminar jugadores</li>
    <li>Registrar y eliminar estadios</li>
</ul>
<p>¡Esperamos que disfrutes de la experiencia y saques el máximo provecho de nuestra aplicación! Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos.</p>
<p>¡Que tengas una excelente jornada futbolística! ⚽🏟️👏</p>
<br/>
<a class="btn btn-primary" href="JugadorServlet">Lista de Jugadores</a>
<a class="btn btn-primary" href="EstadioServlet">Lista de Estadios</a>
</body>
</html>