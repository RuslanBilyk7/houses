package com.houses.dao.impl;

import com.houses.dao.FlatDao;
import com.houses.model.Flat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public class FlatDaoImpl implements FlatDao {

    private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DB_URL = "jdbc:mysql://localhost/houses";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement prst = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Flat> getFlats(Integer id) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        List<Flat> flats;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM houses.flates WHERE houseId" + id + "ORDER BY flatOwner";
            rs = stmt.executeQuery(sql);

            flats = new ArrayList<>();

            while (rs.next()) {
                int flatNumber = rs.getInt("flatNumber");
                String flatOwner = rs.getString("flatOwner");
                int houseId = rs.getInt("houseId");

                Flat flat = new Flat();

                flat.setFlatNumber(flatNumber);
                flat.setFlatOwner(flatOwner);
                flat.setHouseId(houseId);

                flats.add(flat);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        return flats;
    }
}

