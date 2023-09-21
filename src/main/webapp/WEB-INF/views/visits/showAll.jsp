<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 21.09.2023
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizyty</title>
</head>
<body>
<ul>
  <c:forEach items="${visits}" var="visit">
    <li>
        ${visit.date} - ${visit.specialisation}<br/>
        dr ${visit.doctor.fullName}<br/>
        ${visit.hospital.fullAddress}
    </li>
  </c:forEach>
</ul>
</body>
</html>
