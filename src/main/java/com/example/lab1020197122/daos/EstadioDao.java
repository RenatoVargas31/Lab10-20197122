package com.example.lab1020197122.daos;

import com.example.lab1020197122.beans.Estadio;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDao extends BaseDao {
    public ArrayList<Estadio> listarEstadios(){
        ArrayList<Estadio> listaEstadios = new ArrayList<>();

        String sql = "select * from estadio";

        try(Connection conn = getConection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Estadio estadio = new Estadio();
                estadio.setId(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                estadio.setProvincia(rs.getString(3));
                estadio.setClub(rs.getString(4));
                listaEstadios.add(estadio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEstadios;
    }
    public void crearEstadio(Estadio estadio){
        String sql = "insert into estadio (nombre, provincia, club) values (?,?,?)";

        try(Connection conn = getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,estadio.getNombre());
            pstmt.setString(2,estadio.getProvincia());
            pstmt.setString(3,estadio.getClub());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Estadio buscarEstadioPorID(String id){
        Estadio estadio = new Estadio();

        String sql = "select * from estadio where idEstadio = ?";

        try(Connection conn = getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    estadio.setId(rs.getInt(1));
                    estadio.setNombre(rs.getString(2));
                    estadio.setProvincia(rs.getString(3));
                    estadio.setClub(rs.getString(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estadio;
    }
    public void borrarEstadio(String id) throws SQLException {

        String sql = "delete from estadio where idEstadio = ?";

        try(Connection connection = getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,id);
            pstmt.executeUpdate();

        }
    }
}
