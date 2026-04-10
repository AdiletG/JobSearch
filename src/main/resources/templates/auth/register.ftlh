<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JobSearch/Registration</title>
    <link rel="stylesheet" href="/css/register.css">
</head>

<body>
    <div class="container">
        <form action="/auth/register" method="post" enctype="multipart/form-data" class="form">
            <fieldset>
                <div class="legend">
                    <img src="" class="logo" alt="logo">
                </div>

                <div class="form-header">
                    <div class="form-element">
                        <input type="text" name="name" id="user-name" placeholder="Ваше имя" required minlength="3"
                            maxlength="15" pattern="^[A-Za-zА-Яа-я\s]+$"
                            title="Имя должно содержать только буквы и пробелы" autofocus>
                    </div>

                    <div class="form-element">
                        <input type="text" name="surname" id="user-surname" 
                        placeholder="Ваша фамилия" required
                            minlength="5" maxlength="25" pattern="^[A-Za-zА-Яа-я\s]+$"
                            title="Фамилия должна содержать только буквы и пробелы">
                    </div>
                </div>

                <div class="form-neck">
                    <div class="form-element">
                        <input type="number" name="age" id="user-age" placeholder="Ваш возраст" min="16" max="150"
                            required>
                    </div>

                    <div class="form-element">
                        <input type="email" name="email" id="user-email" placeholder="Ваш email" required
                            autocomplete="email" maxlength="254">
                    </div>
                </div>

                <div class="form-body">
                    <div class="form-element">
                        <input type="password" name="password" id="user-password" placeholder="Ваш пароль" required
                            minlength="6" maxlength="26" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).+$"
                            title="Пароль должен содержать минимум 6 символов, одну заглавную букву и одну цифру">
                    </div>

                    <div class="form-element">
                        <input type="password" name="passwordConfirm" id="user-password2"
                            placeholder="Подтвердите ваш пароль" required minlength="6" maxlength="26">
                    </div>
                </div>

                <div class="form-hand">
                    <div class="form-element">
                        <input type="text" name="phoneNumber" id="phone-number" placeholder="Ваш номер телефона"
                            required pattern="^\+?[0-9\s]{10,}$"
                            title="Номер телефона должен содержать минимум 10 символов: цифры, пробелы и знак +">
                    </div>

                    <div class="form-element">
                        <input type="file" id="avatar" name="avatar" accept="image/*">
                    </div>
                </div>

                <div class="form-footer">
                    <div class="form-element">
                        <select name="accountType" id="account-type" required>
                            <option value="" disabled selected>Выберите тип аккаунта</option>
                            <option value="APPLICANT">Соискатель</option>
                            <option value="EMPLOYER">Работодатель</option>
                        </select>
                    </div>
                </div>

                <div class="hr-line"></div>
                
                <div class="form-actions">
                    <a href="/auth/login" class="link">Войти</a>
                    <button type="submit" class="register-button">Зарегистрироваться</button>
                </div>
            </fieldset>
        </form>
    </div>
</body>

</html>