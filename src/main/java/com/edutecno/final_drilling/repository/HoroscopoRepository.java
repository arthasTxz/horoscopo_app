package com.edutecno.final_drilling.repository;

import com.edutecno.final_drilling.dto.HoroscopoDto;
import com.edutecno.final_drilling.modelo.Horoscopo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HoroscopoRepository {

    Optional<Horoscopo> findById(long id);
    void delete(Horoscopo horoscopo);
    void saveHoroscopo(HoroscopoDto horoscopo);
    Optional<Horoscopo> findByDate(Date date);
    List<Horoscopo> findAll();
}
