<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 21.09.2023
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj pacjenta</title>
</head>
<body>
  <form:form method="post" modelAttribute="patient">
      Imię: <form:input path="firstName"/><br/>
      Nazwisko: <form:input path="lastName"/><br/>
      PESEL: <form:input path="pesel"/><br/>
      Mail: <form:input type="mail" path="mail"/><br/>
      Telephone: <form:input path="telephone"/><br/>
      Ulica: <form:input path="street"/><br/>
      Nr domu: <form:input type="number" path="streetNumber"/><br/>
      Nr mieszkania: <form:input type="number" path="flatNumber"/><br/>
      Miasto: <form:input path="city"/><br/>
      Kod pocztowy: <form:input path="postCode"/><br/>
      <button type="submit">Dodaj</button>
  </form:form>
</body>
</html>
