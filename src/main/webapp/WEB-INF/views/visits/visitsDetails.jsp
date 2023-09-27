<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 22.09.2023
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły wizyty</title>
</head>
<body>
  ${visit.specialisation} - dr ${visit.doctor.fullName}<br/>
  ${visit.date}<br/>
  ${visit.hospital.name}<br/>
  ${visit.hospital.fullAddress}<br/>
  Uwagi:<br/>
  ${visit.comments}<br/>
<button onclick="javascript:location.href='/visit/confirmDelete?id=${visit.id}'">Usuń</button>
<button onclick="javascript:location.href='/'">Strona główna</button>
</body>
</html>
