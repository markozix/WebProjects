<!DOCTYPE html>
<html lang="en">
<head>
    <title>Forma</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>

<div id="page-wrap">

    <h1>Unesite asistenta i ocjenu</h1>

    <div id="contact-area">

        <form method="post" action="http://localhost:8080/Domaci_web_6/domaci6">
            <label for="asistent">Asistent:</label>
            <input type="text" name="asistent" id="asistent" />

            <label for="ocjena">Ocjena:</label>
            <input type="text" name="ocjena" id="ocjena" />

            <input type="submit" name="submit" value="Potvrda" class="submit-button" />
        </form>

        <div style="clear: both;"></div>

    </div>

</div>

</body>

</html>