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
 * Created by RUSLAN77 on  22.03.2018 in Ukraine
 */
@WebServlet("/removeHousesServlet")
public class RemoveHousesServlet extends HttpServlet {
    HouseService houseService = new HouseServiceImpl(new HouseDaoImpl());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("houseId");
        if (paramId != null) {
            Integer id = Integer.valueOf(paramId);
            try {
                houseService.removeHouse(id);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }
        resp.sendRedirect("/housesServlet");
    }
}
