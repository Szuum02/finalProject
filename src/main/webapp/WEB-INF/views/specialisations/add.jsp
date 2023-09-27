<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 22.09.2023
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowa specjalizacja</title>
</head>
<body>
<form:form method="post" modelAttribute="specialisation">
    <form:errors path="name" cssClass="error"/>
    Nazwa: <form:input path="name"/><br/>
    <button type="submit">Dodaj</button>
</form:form>
</body>
</html>
