<%--
  Created by IntelliJ IDEA.
  User: RUSLAN77
  Date: 22.03.2018
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Houses</title>
</head>

<body>
LIST OF HOUSES:
<br> <br>

<c:forEach var="item" items="${listOfHouses}">
    <table>

        <tr>
            <td>
                <a href="/flatsServlet?houseId=${item.houseId}">house number = ${item.houseId} , house color = ${item.houseColor}</a>
            </td>
            <td>
                <a href="/addEditHouseServlet?houseId=${item.houseId}">Edit color of house</a>
            </td>
            <td>
                <a href="/removeHousesServlet?houseId=${item.houseId}">Remove house</a>
            </td>
        </tr>
    </table>

</c:forEach>

<a href="/addEditHouseServlet">Add house's color</a>

</body>
</html>
