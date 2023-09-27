<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 22.09.2023
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj szpital</title>
</head>
<body>
<form:form method="post" modelAttribute="hospital">
  <form:errors path="name" cssClass="error"/>
  Nazwa: <form:input path="name"/><br/>
  <form:errors path="street" cssClass="error"/>
  Ulica: <form:input path="street"/><br/>
  <form:errors path="streetNumber" cssClass="error"/>
  Numer budynku: <form:input type="number" path="streetNumber"/><br/>
  <form:errors path="flatNumber" cssClass="error"/>
  Numer mieszkania: <form:input type="number" path="flatNumber"/><br/>
  <form:errors path="city" cssClass="error"/>
  Miasto: <form:input path="city"/><br/>
  <form:errors path="postCode" cssClass="error"/>
  Kod pocztowy: <form:input path="postCode"/><br/>
  <button type="submit">Dodaj</button>
</form:form>
</body>
</html>
