<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 27.09.2023
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planer wizyt</title>
</head>
<body>
<h1>Planer wizyt lekarskich</h1>
<h3>Co chcesz dzisiaj zrobić?</h3>

<h5>Wizyty</h5>
<button onclick="javascript:location.href='/visit/add/selectPatient'">Dodaj wizytę</button><br/>
<button onclick="javascript:location.href='/visit/showAll'">Pokaż wszystkie wizyty</button><br/>

<h5>Pacjenci</h5>
<button onclick="javascript:location.href='/patient/add'">Nowy pacjent</button><br/>
<button onclick="javascript:location.href='/patient/showAll'">Pokaż wszystkich pacjentów</button>

<h5>Lekarze</h5>
<button onclick="javascript:location.href='/doctor/add'">Nowy lekarz</button><br/>
<button onclick="javascript:location.href='/doctor/showAll'">Pokaż wszystkich lekarzy</button>
</body>

<h5>Specjalizacje</h5>
<button onclick="javascript:location.href='/specialisation/add'">Nowa specjalizacja</button><br/>

<h5>Szpitale</h5>
<button onclick="javascript:location.href='/hospital/add'">Nowy szpital</button><br/>
</html>
