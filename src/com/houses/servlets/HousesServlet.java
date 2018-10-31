package com.houses.servlets;


import com.houses.dao.impl.HouseDaoImpl;
import com.houses.service.HouseService;
import com.houses.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by RUSLAN77 on  20.03.2018 in Ukraine
 */
@WebServlet("/housesServlet")
public class HousesServlet extends HttpServlet {
/*Переменную интерфейсного типа можно создать, но объект интерфейсного типа, конечно, создать нельзя. Зато такой переменной можно присвоить объект любого класса, который реализует такой интерфейс.  В данном случае тип у ссылки HouseService (интерфейс), а класс - HouseServiceImpl (то бишь реализация).
*  По определению, объект любого класса, реализующего интерфейс, является объектом типа этого интерфейса. И потому запись HouseService houseService абсолютно правомочна. Этой переменной можно присвоить ссылку на любой объект, реализующий интерфейс HouseService, например, на экземпляр HouseServiceImpl.*/

    private HouseService houseService = new HouseServiceImpl(new HouseDaoImpl());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("listOfHouses", houseService.getHouses());

            //Когда вы получаете исключение ClassNotFoundException, это означает, что JVM прошел весь путь к классам и не обнаружил класс, который вы пытались ссылаться. Решение, как часто в мире Java, состоит в проверке вашего пути к классам.
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("housesList.jsp").forward(req, resp);
    }
}
