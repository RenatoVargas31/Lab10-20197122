package com.example.lab1020197122.servlets;

import com.example.lab1020197122.beans.Estadio;
import com.example.lab1020197122.daos.EstadioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EstadioServlet", value = "/EstadioServlet")
public class EstadioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "listaEstadio" : request.getParameter("action");
        EstadioDao estadioDao = new EstadioDao();

        switch (action){
            case "listaEstadio":
                request.setAttribute("listaEstadio", estadioDao.listarEstadios());
                request.getRequestDispatcher("WEB-INF/Estadio/ListaEstadio.jsp").forward(request, response);
                break;
            case "nuevoEstadio":
                request.getRequestDispatcher("WEB-INF/Estadio/NuevoEstadio.jsp").forward(request, response);
                break;
            case "eliminarEstadio":
                String idDelete = request.getParameter("id");
                System.out.println("idDelete: " + idDelete);
                Estadio estadio = estadioDao.buscarEstadioPorID(idDelete);
                System.out.println("jugadorDelete: " + estadio);

                if(estadio != null){
                    try {
                        estadioDao.borrarEstadio(idDelete);
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/EstadioServlet?action=listaEstadio");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        EstadioDao estadioDao = new EstadioDao();
        String action = request.getParameter("action");

        switch (action){
            case "crearEstadio":
                Estadio estadio = new Estadio();
                estadio.setNombre(request.getParameter("Nombre"));
                estadio.setProvincia(request.getParameter("Provincia"));
                estadio.setClub(request.getParameter("Club"));

                estadioDao.crearEstadio(estadio);

                response.sendRedirect(request.getContextPath() + "/EstadioServlet?action=listaEstadio");
                break;
        }
    }
}
