<%--
  Created by IntelliJ IDEA.
  User: RUSLAN77
  Date: 22.03.2018
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Houses</title>
</head>
<body>
<form action="/addEditHouseServlet?houseId=${house.houseId}" method="post"/>

<input type="text" name="houseColor" value=${house.houseColor}> Color of house (only letters) </input>

<input type="submit" value="Save house's color"/>
</form>

<a href="/housesServlet?houseId=${house.houseId}">Cancel</a>
</body>
</html>
