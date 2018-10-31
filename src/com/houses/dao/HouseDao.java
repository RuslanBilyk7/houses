package com.houses.dao;

import com.houses.model.House;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  20.03.2018 in Ukraine
 */
public interface HouseDao {


    List<House> getHouses() throws ClassNotFoundException, SQLException;

    House getHouseById(Integer id) throws ClassNotFoundException, SQLException;

    void addHouse(House house)throws ClassNotFoundException, SQLException;

    void updateHouse(Integer id, String houseColor)throws ClassNotFoundException, SQLException;

    void removeHouse(Integer id) throws ClassNotFoundException, SQLException;
}
