<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rekisteröityminen</title>
</head>
<link rel="stylesheet" type="text/css" href="style/foorumi.css">
<body>
<nav>
    <a href="index.jsp">Takaisin etusivulle</a>
</nav>
<div id="banneri">
<h1>Tervetuloa Foorumin käyttäjäksi</h1>
</div>
<div id="lomake">
    <form action="rekisteroityminen" method="post">
        <fieldset>
            <legend>Rekisteröidy käyttäjäksi</legend>
            <p>Käyttäjätunnus</p><input type="text" name="nimimerkki" required>
            <p>Nimi</p><input type="text" name="nimi" required>
            <p>Salasana</p><input type="password" name="salasana" required>
            <p>Rooli, esim. velho, virtuoosi, MESTARI</p><input type="text" name="kuvaus" required>
            <p>Minusta</p><textarea name="kuvausteksti" id="kuvausteksti" cols="30" rows="10" required></textarea>
            <br>
            <input type="submit" value="Rekisteröidy">
        </fieldset>
    </form>
</div>

</body>
</html>
