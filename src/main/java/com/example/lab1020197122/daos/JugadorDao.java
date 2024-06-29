package com.example.lab1020197122.daos;

import com.example.lab1020197122.beans.Estadio;
import com.example.lab1020197122.beans.Jugador;
import com.example.lab1020197122.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDao extends BaseDao{
    //Jugadores
    public ArrayList<Jugador> listarJugadores(){
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql = "select * from jugador j join seleccion s on j.sn_idSeleccion = s.idSeleccion ";

        try(Connection conn = getConection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Jugador jugador = new Jugador();
                Seleccion seleccion = new Seleccion();
                jugador.setId(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                seleccion.setNombre(rs.getString(8));
                jugador.setSeleccion(seleccion);
                listaJugadores.add(jugador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaJugadores;
    }
    public ArrayList<Seleccion> listarSeleccion(){
        ArrayList<Seleccion> listaSeleccion = new ArrayList<>();

        String sql = "select * from seleccion";

        try(Connection conn = getConection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Seleccion seleccion = new Seleccion();
                seleccion.setId(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                listaSeleccion.add(seleccion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaSeleccion;
    }
    public Seleccion buscarSeleccionPorID(String id){
        Seleccion seleccion = new Seleccion();

        String sql = "select * from seleccion where idSeleccion = ?";

        try(Connection conn = getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    seleccion.setId(rs.getInt(1));
                    seleccion.setNombre(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return seleccion;
    }
    public void crearJugador(Jugador jugador){
        String sql = "insert into jugador (nombre, edad, posicion, club, sn_idSeleccion) values (?,?,?,?,?)";

        try(Connection conn = getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,jugador.getNombre());
            pstmt.setInt(2,jugador.getEdad());
            pstmt.setString(3,jugador.getPosicion());
            pstmt.setString(4,jugador.getClub());
            pstmt.setInt(5,jugador.getSeleccion().getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Jugador buscarJugadorPorID(String id){
        Jugador jugador = new Jugador();
        Seleccion seleccion = new Seleccion();

        String sql = "select * from jugador j join seleccion s on j.sn_idSeleccion = s.idSeleccion where j.idJugador = ?";

        try(Connection conn = getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    jugador.setId(rs.getInt(1));
                    jugador.setNombre(rs.getString(2));
                    jugador.setEdad(rs.getInt(3));
                    jugador.setPosicion(rs.getString(4));
                    jugador.setClub(rs.getString(5));
                    seleccion.setNombre(rs.getString(8));
                    jugador.setSeleccion(seleccion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jugador;

    }
    public void borrarJugador(String id) throws SQLException {

        String sql = "delete from jugador where idJugador = ?";

        try(Connection connection = getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,id);
            pstmt.executeUpdate();

        }
    }
}
