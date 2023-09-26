<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 21.09.2023
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pacjenci</title>
</head>
<body>
<ul>
  <c:forEach items="${pateints}" var="pateint">
    <li>
      ${pateint.firstName} ${pateint.lastName}<br/>
      <c:forEach items="${pateint.doctors}" var="doctor">
          ${doctor.fullName}<br/>
      </c:forEach>
    </li>
  </c:forEach>
</ul>
</body>
</html>
