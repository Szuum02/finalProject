<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 27.09.2023
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lekarze</title>
</head>
<body>
<ul>
    <c:forEach items="${doctors}" var="doctor">
        <li>
            dr ${doctor.fullName}
            <ul>
                <c:forEach items="${doctor.specializations}" var="spec">
                    <li>${spec.name}</li>
                </c:forEach>
            </ul>
            <button onclick="javascript:location.href='/doctor/confirmDelete?id=${doctor.id}'">Usuń</button>
        </li>
    </c:forEach>
</ul>
<button onclick="javascript:location.href='/'">Powrót</button>
</body>
</html>
