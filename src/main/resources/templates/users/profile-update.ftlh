<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JobSearch/Registration</title>
    <link rel="stylesheet" href="/css/register.css">
    <#import "/spring.ftl" as spring>
</head>

<body>
    <div class="container">
        <form action="/profile/update" method="post" enctype="multipart/form-data" class="form">

            <#if _csrf??>
                <input type="hidden"
                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}">
            </#if>

            <fieldset>
                <div class="legend">
                   
                </div>

                <div class="form-header">
                    <div class="form-element">
                        <@spring.formInput "userDto.name" 'id="user-name" class="form-control" placeholder="Ваше имя" autofocus' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "userDto.surname" 'id="user-surname" class="form-control" placeholder="Ваша фамилия" required' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-neck">
                    <div class="form-element">
                        <@spring.formInput "userDto.age" 'id="user-age" class="form-control" placeholder="Ваш возраст" required' "number" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "userDto.email" 'id="user-email" class="form-control" placeholder="Ваш email@example.com " required' "email" />

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-body">
                    <div class="form-element">
                        <@spring.formPasswordInput "userDto.password" 'id="user-password" class="form-control" placeholder="Ваш пароль"' />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formPasswordInput "userDto.passwordConfirm" 'id="user-passwordConfirm" class="form-control" placeholder="Подтвердите ваш пароль" ' />

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-hand">
                    <div class="form-element">
                        <@spring.formInput "userDto.phoneNumber" 'id="user-phoneNumber" class="form-control" placeholder="Ваш номер телефона" required' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "userDto.avatar" 'id="user-avatar" class="form-control" accept="image/*" ' "file" />

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="hr-line"></div>

                <div class="form-actions">
                    <a href="/profile" class="link">Назад</a>
                    <button type="submit" class="register-button">Редактировать</button>
                </div>
            </fieldset>
        </form>
    </div>
</body>

</html>