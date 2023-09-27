<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 22.09.2023
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowy doktor</title>
</head>
<body>
<form:form id="form" method="post" modelAttribute="doctor">
    <form:errors path="firstName" cssClass="error"/>
    Imię: <form:input id="firstName" path="firstName"/><br/>

    <form:errors path="lastName" cssClass="error"/>
    Nazwisko: <form:input id="lastName" path="lastName"/><br/>

    <label for="specialisation" id="specialisationLabel">Specjalizacje: </label>
    <form:errors path="specializations" cssClass="error"/>
    <form:select id="specialisation" path="specializations" items="${specialisations}" itemLabel="name" itemValue="id"/>

    <button id="newSpecialisation">Nowa specjalizacja</button><br/>
    <label for="hospital" id="hospitalLabel">Szpitale: </label>
    <form:errors path="hospitals" cssClass="error"/>
    <form:select id="hospital" path="hospitals" items="${hospitals}" itemLabel="name" itemValue="id"/>
    <button id="newHospital">Nowy szpital</button><br/>
    <button id="submitButton" type="submit">Dodaj</button>
</form:form>
</body>
<script type="text/javascript" src="/js/addForms/addForm.js"></script>
<script type="text/javascript" src="/js/addForms/newHospital.js"></script>
<script type="text/javascript" src="/js/addForms/newSpecialisation.js"></script>
</html>
