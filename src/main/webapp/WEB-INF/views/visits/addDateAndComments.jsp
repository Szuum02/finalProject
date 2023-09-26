<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 26.09.2023
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowa wizyta</title>
</head>
<body>
Pacjent: ${visit.patient.fullName}<br/>
Specjalista: ${visit.specialisation}<br/>
Lekarz: ${visit.doctor.fullName}<br/>
Szpital: ${visit.hospital.name} - ${visit.hospital.city}<br/>
<form:form action="/visit/add/createVisit" modelAttribute="visit">
    <form:input path="patient" type="hidden" value="${visit.patient.id}"/>
    <form:input path="specialisation" type="hidden" value="${visit.specialisation}"/>
    <form:input path="doctor" type="hidden" value="${visit.doctor.id}"/>
    <form:input path="hospital" type="hidden" value="${visit.hospital.id}"/>
    Data: <input type="date" name="date"/><br/>
    Godzina: <input name="time"><br/>
    Komentarz: <br/>
    <form:textarea path="comments"/><br/>
    <button type="submit">Zapisz</button>
</form:form>
</body>
</html>
