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
      <form:errors path="firstName" cssClass="error"/>
      Imię: <form:input path="firstName"/><br/>
      <form:errors path="lastName" cssClass="error"/>
      Nazwisko: <form:input path="lastName"/><br/>
      <form:errors path="pesel" cssClass="error"/>
      PESEL: <form:input path="pesel"/><br/>
      <form:errors path="mail" cssClass="error"/>
      Mail: <form:input type="mail" path="mail"/><br/>
      <form:errors path="telephone" cssClass="error"/>
      Telefon: <form:input path="telephone"/><br/>
      <form:errors path="street" cssClass="error"/>
      Ulica: <form:input path="street"/><br/>
      <form:errors path="streetNumber" cssClass="error"/>
      Nr domu: <form:input type="number" path="streetNumber"/><br/>
      <form:errors path="flatNumber" cssClass="error"/>
      Nr mieszkania: <form:input type="number" path="flatNumber"/><br/>
      <form:errors path="city" cssClass="error"/>
      Miasto: <form:input path="city"/><br/>
      <form:errors path="postCode" cssClass="error"/>
      Kod pocztowy: <form:input path="postCode"/><br/>
      <button type="submit">Dodaj</button>
  </form:form>
</body>
</html>
