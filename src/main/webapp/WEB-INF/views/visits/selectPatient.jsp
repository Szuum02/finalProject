<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 22.09.2023
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowa wizyta</title>
    <link rel="icon" href="data:;base64," type="image/x-icon">
</head>
<body>
<form:form id="form" method="post" modelAttribute="visit">
    <label id="patientLabel" for="patients">Pacjent</label>
    <form:select id="patients" path="patient" items="${patients}" itemLabel="fullName" itemValue="id"/> <button id="patientButton">Nowy pacjent</button><br/>
    <button id="submitButton" type="submit">Dalej</button>
</form:form>
</body>
<script type="text/javascript" src="/js/addForms/addForm.js"></script>
<script type="text/javascript" src="/js/addForms/newPatient.js"></script>
</html>
