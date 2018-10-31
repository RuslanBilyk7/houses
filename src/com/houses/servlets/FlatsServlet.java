package com.houses.servlets;

import com.houses.dao.impl.FlatDaoImpl;
import com.houses.dao.impl.HouseDaoImpl;
import com.houses.service.FlatService;
import com.houses.service.HouseService;
import com.houses.service.impl.FlatServiceImpl;
import com.houses.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/flatsServlet")
public class FlatsServlet extends HttpServlet {
    private FlatService flatService = new FlatServiceImpl(new FlatDaoImpl());
    private HouseService houseService = new HouseServiceImpl(new HouseDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String houseId = req.getParameter("houseId");
            if (houseId != null) {
                req.setAttribute("flatsList", flatService.getFlats(Integer.valueOf(houseId)));
                req.setAttribute("houseId",houseId);
//                req.setAttribute("flatOwner",flatOwner );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("flatsList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
