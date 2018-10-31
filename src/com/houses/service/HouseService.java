package com.houses.service;

import com.houses.model.House;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public interface HouseService  {

    List<House> getHouses() throws ClassNotFoundException, SQLException;

    House getHouseById(Integer id) throws ClassNotFoundException,SQLException;

    void addHouse(House house)throws ClassNotFoundException,SQLException;

    void updateHouse(Integer id, String houseColor) throws ClassNotFoundException,SQLException;

    void removeHouse(Integer id) throws ClassNotFoundException,SQLException;
}
