<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JobSearch/login</title>
    <link rel="stylesheet" href="/css/login.css" />
</head>

<body>

    <div class="container">
        <form action="/auth/login" method="post" class="form">
            <fieldset>
                <div class="legend">
                    <img src="/logo/logo.png" class="logo">
                </div>

                <div class="form-element">
                    <label for="user-email">email</label>
                    <input type="email" name="username" id="user-email" placeholder="Ваш email" required autofocus>
                </div>

                <div class="form-element">
                    <label for="user-password">Пароль</label>
                    <input type="password" name="password" id="user-password" placeholder="Ваш пароль" required>
                </div>

                <div class="hr-line"></div>

                <div class="form-element form-footer">
                    <a href="/auth/register" class="link">Регистрация</a>
                    <button class="register-button" type="submit">Войти</button>
                </div>
            </fieldset>
        </form>
    </div>

</body>

</html>