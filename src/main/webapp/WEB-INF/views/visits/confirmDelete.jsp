<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 27.09.2023
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdź usunięcie</title>
</head>
<body>
Czy na pewno chcesz usunąć wiztę:<br/>
Pacjent: ${visit.patient.fullName}<br/>
Lekarz: ${visit.doctor.fullName} - ${visit.specialisation}<br/>
Wizyta: ${visit.date} - ${visit.hospital.name} (${visit.hospital.city})<br/>
<button onclick="javascript:location.href='/visit/delete?id=${visit.id}'">Tak</button>
<button onclick="javascript:location.href='/'">Nie</button>
</body>
</html>
