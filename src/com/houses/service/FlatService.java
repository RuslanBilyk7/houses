package com.houses.service;

import com.houses.model.Flat;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public interface FlatService {
    List <Flat> getFlats(Integer id) throws ClassNotFoundException, SQLException;

}
