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
  Nazwa: <form:input path="name"/><br/>
  Ulica: <form:input path="street"/><br/>
  Numer budynku: <form:input type="number" path="streetNumber"/>
  Numer mieszkania: <form:input type="number" path="flatNumber"/><br/>
  Miasto: <form:input path="city"/><br/>
  Kod pocztowy: <form:input path="postCode"/><br/>
  <button type="submit">Dodaj</button>
</form:form>
</body>
</html>
