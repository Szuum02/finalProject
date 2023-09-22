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
<form:form method="post" modelAttribute="doctor">
    Imię: <form:input path="firstName"/><br/>
    Nazwisko: <form:input path="lastName"/><br/>
    Specializacje: <form:select path="specializations" items="${specialisations}" itemLabel="name" itemValue="id"/><br/>
    Szpitale: <form:select path="hospitals" items="${hospitals}" itemLabel="name" itemValue="id"/><br/>
    <button type="submit">Dodaj</button>
</form:form>
</body>
</html>
