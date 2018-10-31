package com.houses.service.impl;

import com.houses.dao.HouseDao;
import com.houses.dao.impl.HouseDaoImpl;
import com.houses.model.House;
import com.houses.service.HouseService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao = new HouseDaoImpl();

    public HouseServiceImpl(HouseDao houseDao) {

    }

    @Override
    public List<House> getHouses() throws ClassNotFoundException, SQLException {
        return houseDao.getHouses();
    }

    @Override
    public void addHouse(House house) throws ClassNotFoundException, SQLException {
        houseDao.addHouse(house);
    }

    @Override
    public void updateHouse(Integer id, String houseColor) throws ClassNotFoundException, SQLException {
        houseDao.updateHouse(id, houseColor);
    }

    @Override
    public void removeHouse(Integer id) throws ClassNotFoundException, SQLException {
        houseDao.removeHouse(id);
    }

    @Override
    public House getHouseById(Integer id) throws ClassNotFoundException, SQLException {
        return houseDao.getHouseById(id);


    }
}