<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JobSearch/Vacancies</title>
    <link rel="stylesheet" href="/css/vacancy-create.css">
    <#import "/spring.ftl" as spring>
</head>

<body>
    <div class="container">
        <form action="/vacancies/update/${vacancy.id}" method="post" enctype="multipart/form-data" class="form">

            <#if _csrf??>
                <input type="hidden"
                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}">
            </#if>

            <fieldset>
                <div class="legend">
                    <img src="/logo/logo.png" class="logo" alt="logo">
                </div>

                <div class="form-header">
                    <div class="form-element">
                        <@spring.formInput "vacancy.name" 'id="vacancy-name" class="form-control" placeholder="Название" autofocus' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formTextarea "vacancy.description" 'id="vacancy-description" class="form-control descrip" placeholder="Описание" required' />

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-element">
                    <@spring.formInput "vacancy.salary" 'id="vacancy-salary" class="form-control" placeholder="Заработная плата" required' "number" />

                    <@spring.showErrors "<br>" "error" />
                </div>

                <div class="form-neck">

                    <div class="form-element">
                        <@spring.formInput "vacancy.expFrom" 'id="vacancy-exp-from" class="form-control" placeholder="Опыт работы от:" required' "number" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "vacancy.expTo" 'id="vacancy-exp-to" class="form-control" placeholder="Опыт работы до:" required' "number" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                </div>

                <div class="form-footer">
                    <div class="form-element">
                        <div class="select-wrapper">
                            <@spring.formSingleSelect "vacancy.categoryId"
                                categories 'id="categories-type" class="form-control custom-select" required' />
                        </div>

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-element">
                    <div class="checkBlock">
                        <p class="checkBox">Активна</p>
                        <@spring.formCheckbox "vacancy.isActive" 'id="isActive" class="form-control check" ' />
                    </div>
                </div>
                
                <div class="hr-line"></div>

                <div class="form-actions">
                    <a href="/profile" class="link">Назад</a>
                    <button type="submit" class="register-button">Обновить вакансию</button>
                </div>
            </fieldset>
        </form>
    </div>
</body>

</html>