<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
    <title>Hakutulokset</title>
    <link rel="stylesheet" type="text/css" href="style/foorumi.css">
</head>
<body>
<nav>
    <a class="linkit" href="index.jsp">Takaisin etusivulle</a>
</nav>
<div id="banneri">
    <h1>Hakutulokset</h1>
</div>
    <div>
        <table border="1">
            <tr>
                <th colspan="3"><h2>Hakutulokset</h2></th>
            </tr>
            <tr>
                <th>Otsikko</th><th>Viesti</th><th>Kirjoitettu</th>
            </tr>

            <c:forEach var="viesti" items="${sessionScope.haku}">
                <tr><td><a href="viesti?value=${viesti.viestiID}" value="viestiID" action="viesti" method="post">${viesti.otsikko}</a></td>
                    <td>${viesti.viesti}"</td>
                    <td>${viesti.ajankohta}"</td>
                </tr>
            </c:forEach>

        </table>
    </div>

</body>
</html>
