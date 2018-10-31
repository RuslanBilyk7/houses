package com.houses.dao;

import com.houses.model.Flat;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  20.03.2018 in Ukraine
 */
public interface FlatDao {
    List<Flat> getFlats(Integer id) throws ClassNotFoundException,SQLException;

}
