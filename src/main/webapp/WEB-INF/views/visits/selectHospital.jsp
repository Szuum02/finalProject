<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 26.09.2023
  Time: 21:25
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
<form:form id="form" action="/visit/add/selectHospital" method="post" modelAttribute="visit">
    <form:input path="patient" type="hidden" value="${visit.patient.id}"/>
    <form:input path="specialisation" type="hidden" value="${visit.specialisation}"/>
    <form:input path="doctor" type="hidden" value="${visit.doctor.id}"/>
    <label id="hospitalLabel" for="hospital">Szpital: </label>
    <form:select id="hospital" type="select" path="hospital" items="${hospitals}" itemLabel="name" itemValue="id"/>
    <button id="newHospital">Inny szpital</button><br/>
    <button id="submitButton" type="submit">Dalej</button>
</form:form>
</body>
<script type="text/javascript" src="/js/addForms/addForm.js"></script>
<script type="text/javascript" src="/js/addForms/newHospital.js"></script>
</html>
