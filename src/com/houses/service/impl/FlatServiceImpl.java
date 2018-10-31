package com.houses.service.impl;

import com.houses.dao.FlatDao;
import com.houses.dao.impl.FlatDaoImpl;
import com.houses.model.Flat;
import com.houses.service.FlatService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public class FlatServiceImpl implements FlatService {
   private FlatDao flatDao;

    public FlatServiceImpl(FlatDaoImpl flatDao) {
    }

    @Override
    public List<Flat> getFlats(Integer id) throws ClassNotFoundException, SQLException {
        return null;
    }
}
