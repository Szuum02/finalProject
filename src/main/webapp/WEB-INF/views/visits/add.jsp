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
    <title>Dodaj wizytę</title>
    <link rel="icon" href="data:;base64," type="image/x-icon">
</head>
<body>
<form:form id="form" method="post" modelAttribute="visit">
    Pacjent: <form:select path="patient" items="${patients}" itemLabel="fullName" itemValue="id"/><br/>
    Lekarz: <form:select id="doctorLabel" path="doctor" items="${patient.doctors}" itemLabel="fullName" itemValue="id"/> <button id="newDoctor">Nowy lekarz</button><br/>
</form:form>
</body>
<script type="text/javascript" src="/js/visits/addForm.js"></script>
</html>
