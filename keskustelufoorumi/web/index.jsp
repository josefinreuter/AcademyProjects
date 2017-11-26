<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<sql:query var="alue" dataSource="jdbc/FoorumiDB">
    SELECT nimi, alueid FROM alue
</sql:query>
<sql:query var="uusimmat" dataSource="jdbc/FoorumiDB">
    SELECT viesti.otsikko, henkilo.nimimerkki, alue.nimi, viesti.viesti, viesti.id
    FROM viesti JOIN henkilo ON viesti.kirjoittaja=henkilo.hloid
    JOIN alue ON alue.alueid=viesti.alueid WHERE vastaus IS NULL ORDER BY viesti.kirjoitettu DESC LIMIT 5
</sql:query>

<html>
<head>
    <title>Foorumi</title>
    <link rel="stylesheet" type="text/css" href="style/foorumi.css">
</head>
<body>
<nav>
    <c:choose>
        <c:when test="${sessionScope.knimi != null}">
            <a class="linkit" href="LogoutServlet">Kirjaudu ulos</a>  <a class="linkit" href="ProfiiliServlet">Profiili</a>
        </c:when>
        <c:otherwise>
            <form id="login" action="LoginServlet" method="post">
                <p>Käyttäjätunnus<input type="text" name="kayttajanimi" required> Salasana<input type="password" name="salasana" required> <input type="submit" value="Sisään"></p>
            </form>
            <a class="linkit" href="rekisteroityminen.jsp">Rekisteröidy käyttäjäksi</a>
        </c:otherwise>
    </c:choose>
</nav>
<div id="banneri">
    <h1>FOORUMI</h1>
    <h5>Täällä voit keskustella kaikesta hauskasta.</h5>
</div>
<br>
<br>
<div id="aihealueet">
    <h3>Keskustelualueet</h3>
    <c:forEach var="row" items="${alue.rows}">
        <a href="Keskustelut?value=${row.alueid}" value="nro" action="Keskustelut" method="post">${row.nimi}</a><br><br>
    </c:forEach>
    <br>
    <form action="HakuServlet" method="post">
        <fieldset>
            <legend>Etsi kiinnostavia keskusteluja</legend>
            <h5>Syötä hakusana</h5><input type="text" name="hakusana" required>
            <br>
            <input type="submit" value="Hae">
        </fieldset>
    </form>
</div>
<div id="fiidi">
    <table>
        <tr>
            <th colspan="4"><h2>Uusimmat viestit</h2></th>
        </tr>
        <tr>
            <th>Otsikko</th><th>Viesti</th><th>Kirjoittaja</th><th>Aihealue</th>
        </tr>
        <c:forEach var="row" items="${uusimmat.rows}">
            <tr>
                <td><a href="viesti?value=${row.id}" method="post">${row.otsikko}</a></td>
                <td>${row.viesti}</td>
                <td>${row.nimimerkki}</td>
                <td>${row.nimi}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>