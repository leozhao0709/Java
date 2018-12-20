<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="httptest" method="post">
    <div>
        <label for="username">UserName: </label>
        <input type="text" id="username" name="username">
    </div>

    <div>
        <label for="password">password: </label>
        <input type="password" id="password" name="password">
    </div>

    <div>
        <label>Hobby: </label>

        <input type="checkbox" name="hobby" id="basketBall" value="basketBall">
        <label for="basketBall">Basket Ball</label>

        <input type="checkbox" name="hobby" id="footBall" value="footBall">
        <label for="footBall">Foot Ball</label>

        <input type="checkbox" name="hobby" id="volleyBall" value="volleyBall">
        <label for="volleyBall">Volley Ball</label>
    </div>

    <button type="submit">Submit</button>
</form>
</body>
</html>
