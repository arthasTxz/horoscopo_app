package com.edutecno.final_drilling.repository;

import com.edutecno.final_drilling.configuration.DatabaseConnection;
import com.edutecno.final_drilling.dto.HoroscopoDto;
import com.edutecno.final_drilling.modelo.Horoscopo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoroscopoRepositoryImpl implements HoroscopoRepository {
    @Override
    public Optional<Horoscopo> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveHoroscopo(HoroscopoDto horoscopo) {
        String query = "INSERT INTO horoscopo (animal, fecha_inicio, fecha_final) values (?,?,?)";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, horoscopo.getAnimal());
            ps.setDate(2, (Date) horoscopo.getFechaInicio());
            ps.setDate(3, (Date) horoscopo.getFechaFin());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Horoscopo> findByDate(java.util.Date date) {
        String query = "" ;
        Optional<Horoscopo> horoscopo = Optional.empty();
        return horoscopo;
    }

    @Override
    public void delete(Horoscopo horoscopo) {

    }

    @Override
    public List<Horoscopo> findAll() {
        List<Horoscopo> listaHoroscopo = new ArrayList<>();
        String query = "SELECT * FROM horoscopo";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                Horoscopo horoscopo = new Horoscopo();
                horoscopo.setId(rs.getInt("id"));
                horoscopo.setAnimal(rs.getString("animal"));
                horoscopo.setFechaInicio(rs.getDate("fecha_inicio"));
                horoscopo.setFechaFin(rs.getDate("fecha_final"));
                listaHoroscopo.add(horoscopo);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return listaHoroscopo;
    }
}
