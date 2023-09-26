<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 26.09.2023
  Time: 20:32
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
<form:form id="form" action="/visit/add/selectDoctor" method="post" modelAttribute="visit">
    <label id="doctorLabel" for="doctor">Lekarz: </label>
    <form:input path="patient" type="hidden" value="${visit.patient.id}"/>
    <form:input path="specialisation" type="hidden" value="${visit.specialisation}"/>
    <form:select id="doctor" type="select" path="doctor" items="${doctors}" itemLabel="fullName" itemValue="id"/>
    <button id="newDoctor">Inny lekarz</button><br/>
    <button id="submitButton" type="submit">Dalej</button>
</form:form>
</body>
<script type="text/javascript" src="/js/addForms/addForm.js"></script>
<script type="text/javascript" src="/js/addForms/newDoctor.js"></script>
</html>
