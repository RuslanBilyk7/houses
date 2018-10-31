package com.houses.servlets;

import com.houses.dao.impl.HouseDaoImpl;
import com.houses.model.House;
import com.houses.service.HouseService;
import com.houses.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addEditHouseServlet")
public class AddEditHouseServlet extends HttpServlet {
    private HouseService houseService = new HouseServiceImpl(new HouseDaoImpl());
    House house;

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*getParameter() возвращает параметры http-запроса. Они передаются от клиента к серверу. Например http://example.com/servlet?parameter=1. Может возвращать только String

getAttribute() используется только для использования на стороне сервера - вы заполняете запрос атрибутами, которые вы можете использовать в рамках одного запроса. Например, вы устанавливаете атрибут в сервлет и читаете его из JSP. Может использоваться для любого объекта, а не только для строки.*/
        String paramId = req.getParameter("houseId");
        //Если null, то значит это создание нового house и программа перейдет после if к  req.getRequestDispatcher("addEditHouse.jsp"). А если не null, то значит нужно получить имя редактрируемого house и потом перейти к  req.getRequestDispatcher("addEditHouse.jsp")

        if (paramId != null) {
            Integer houseId = Integer.valueOf(paramId);
            House house = null;

            try {
                house = houseService.getHouseById(houseId);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("house", house);
        }
        req.getRequestDispatcher("addEditHouse.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String houseId = req.getParameter("houseId");
        String houseColor = req.getParameter("houseColor");

        //Если вам нужно проверить, содержит ли строка пустое значение — используйте метод isEmpty().
        if (houseId == null || houseId.isEmpty()) {  //if true -add new house
            House house = new House();
            house.setHouseColor(houseColor);

            if (houseColor != null) {
                try {
                    houseService.addHouse(house);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {                                   //else- edit color of house
            Integer id = Integer.valueOf(houseId);
            try {
                houseService.updateHouse(id, houseColor);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/housesServlet");
    }
}

