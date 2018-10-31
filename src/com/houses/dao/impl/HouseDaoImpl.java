package com.houses.dao.impl;

import com.houses.dao.HouseDao;
import com.houses.model.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
public class HouseDaoImpl implements HouseDao {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/houses";
    //Класс java.sql.Connection представляет в JDBC сеанс работы с базой данных. Он предоставляет приложению объекты Statement (и его подклассы) для этого сеанса.
    private static Connection conn = null;
    // Класс Statement представляет встроенную команду SQL и используется приложением для доступа к базе данных. При закрытии Statement автоматически закрываются все связанные с ним открытые объекты ResultSet.
    private static Statement stmt = null;
    private static PreparedStatement prst = null;

    //Для использования SQL запросов существуют 3 типа объектов:
    //1.Statement: используется для простых случаев без параметров
    //2.PreparedStatement: предварительно компилирует запросы,
    //которые могут содержать входные параметры
    // ? - место вставки нашего значеня

    //3.CallableStatement: используется для вызова хранимых функций,
    // которые могут содержать входные и выходные параметры

    static {
        try {
            //Загружаем драйвер
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<House> getHouses() throws ClassNotFoundException, SQLException {
        /*Класс ResultSet представляет результирующий набор базы данных. Он обеспечивает приложению построчный доступ к результатам запросов в базе данных. Во время обработки запроса ResultSet поддерживает указатель на текущую обрабатываемую строку. Приложение последовательно перемещается по результатам, пока они не будут все обработаны или не будет закрыт ResultSet.*/
        ResultSet rs = null;
        List<House> houses;

        try {
            //это передача сведений о подключении к базе данных в виде URL-адреса подключения
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();
            String sql = "SELECT houseId, houseColor FROM houses ORDER BY houseColor";
            //Метод executeQuery() используется для выполнения запросов (на извлечение данных). Он возвращает для обработки результирующий набор.
            rs = stmt.executeQuery(sql);

            houses = new ArrayList<>();

            /*public boolean next() throws SQLException
public boolean previous() throws SQLException
Эти методы позволяют переместиться в результирующем наборе на одну строку вперед или назад. Во вновь созданном результирующем наборе курсор устанавливается перед первой строкой, поэтому первое обращение к методу next() влечет позиционирование на первую строку. Эти методы возвращают true, если остается строка для дальнейшего перемещения. Если строк для обработки больше нет, возвращается false.*/
            while (rs.next()) {
                int houseId = rs.getInt("houseId");
                String houseColor = rs.getString("houseColor");
                House house = new House();
                house.setHouseId(houseId);
                house.setHouseColor(houseColor);
                houses.add(house);
            }
        } finally {
            if (rs != null) {
                //Осуществляет немедленное закрытие ResultSet вручную. Обычно этого не требуется, так как закрытие Statement, связанного с ResultSet, автоматически закрывает ResultSet
                rs.close();
            }
            stmt.close();
        }
        return houses;
    }


    @Override
    public House getHouseById(Integer id) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        House house = null;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            String sql = "SELECT houseId, houseColor FROM houses WHERE houseId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                house = new House();
                house.setHouseId(rs.getInt("houseId"));
                house.setHouseColor(rs.getString("houseColor"));
                return house;
            }
        } finally {
            if (rs != null)
                rs.close();
        }
        return house;
    }

    @Override
    public void addHouse(House house) throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            String sql = "INSERT INTO houses(houseColor) VALUES(?)";
            prst = conn.prepareStatement(sql);
            prst.setString(1, house.getHouseColor());
            prst.executeUpdate();
        } finally {
            if (prst != null)
                prst.close();
        }

    }

    @Override
    public void updateHouse(Integer id, String houseColor) throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            String sql = "UPDATE houses SET houseColor=? WHERE houseId=?";
            prst = conn.prepareStatement(sql);
            prst.setString(1, houseColor);
            prst.setInt(2, id);
            prst.executeUpdate();
        } finally {
            if (prst != null)
                prst.close();
        }
    }

    @Override
    public void removeHouse(Integer id) throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "DELETE FROM houses WHERE houseId=?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);
            prst.executeUpdate();
        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }
}
