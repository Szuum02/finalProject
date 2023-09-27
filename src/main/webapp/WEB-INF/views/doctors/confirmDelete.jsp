<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 27.09.2023
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdź usunięcie</title>
</head>
<body>
Czy na pewno chcesz usunąć lekarza: ${doctor.fullName}<br/>
<button onclick="javascript:location.href='/doctor/delete?id=${doctor.id}'">Tak</button>
<button onclick="javascript:location.href='/'">Nie</button>
</body>
</html>
