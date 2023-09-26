<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 26.09.2023
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowa wizyta</title>
</head>
<body>
Pacjent: ${visit.patient.fullName}<br/>
<form:form id="form" action="/visit/add/selectSpecialisation" method="post" modelAttribute="visit">
    <label id="specialisationLabel" for="specialisation">Specjalizacja: </label>
    <form:input type="hidden" path="patient" value="${visit.patient.id}"/>
    <form:select id="specialisation" path="specialisation" items="${specialisations}" itemLabel="name" itemValue="name"/>
    <button id="newSpecialisation">Inna specjalizacja</button><br/>
    <button id="submitButton" type="submit">Dalej</button>
</form:form>
</body>
<script type="text/javascript" src="/js/addForms/addForm.js"></script>
<script type="text/javascript" src="/js/addForms/newSpecialisation.js"></script>
</html>
