<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JobSearch/resumes</title>
    <link rel="stylesheet" href="/css/resume-create.css">
    <#import "/spring.ftl" as spring>
</head>

<body>
    <div class="container">
        <form action="/resumes/update/${resume.id}" method="post" class="form">
            <fieldset>
                <div class="legend">
                    <img src="/logo/logo.png" class="logo" alt="logo">
                </div>

                <div class="form-header">
                    <div class="form-element">
                        <@spring.formInput "resume.name" 'id="resume-name" class="form-control" placeholder="Название" autofocus' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "resume.salary" 'id="resume-salary" class="form-control" placeholder="Заработная плата" required' "number" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <div class="select-wrapper">
                            <@spring.formSingleSelect "resume.categoryId"
                                categories 'id="categories-type" class="form-control custom-select" required' />
                        </div>

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-body">
                    <p class="text">Место обучение</p>
                    <div class="form-element">
                        <@spring.formInput "resume.educations[0].institution" 'id="education-institution" class="form-control" placeholder="Название учебного заведение" ' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "resume.educations[0].program" 'id="education-program" class="form-control" placeholder="Название программы обучение" ' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "resume.educations[0].startDate" 'id="education-startDate" class="form-control" placeholder="Начала обучение:"' "date" />

                        <@spring.showErrors "<​br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "resume.educations[0].endDate" 'id="education-endDate" class="form-control" placeholder="Конец обучение:"' "date" />

                        <@spring.showErrors "<​br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "resume.educations[0].degree" 'id="education-degree" class="form-control" placeholder=""' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                </div>



                <div class="form-neck">
                    <p class="text">Опыт работы</p>
                    <div class="form-element">
                        <@spring.formInput "resume.workExperiences[0].companyName" 'id="work-companyName" class="form-control" placeholder="Название место работы" ' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formInput "resume.workExperiences[0].position" 'id="work-position" class="form-control" placeholder="Название позиции" ' "text" />

                        <@spring.showErrors "<br>" "error" />
                    </div>

                    <div class="form-element">
                        <@spring.formTextarea "resume.workExperiences[0].responsibilities" 'id="work-responsibilities" class="form-control descrip" placeholder="Обязанности которые вы выполняли" ' />

                        <@spring.showErrors "<br>" "error" />
                    </div>
                </div>

                <div class="form-footer">
                    <p class="text-black">Контакты</p>
                    <#list contactTypes as contactType>
                        <div class="form-element">
                            <input type="hidden" name="contacts[${contactType?index}].type_id"
                                value="${contactType.id}" />
                            <@spring.formInput "resume.contacts[${contactType?index}].contactValue" 'class="form-control" placeholder="Введите ${contactType.type}"' "text" />
                        </div>
                    </#list>
                </div>

                <div class="form-element">
                    <div class="checkBlock">
                        <p class="checkBox">Активна</p>
                        <@spring.formCheckbox "resume.isActive" 'id="isActive" class="form-control check" ' />
                    </div>
                </div>

                <div class="hr-line"></div>

                <div class="form-actions">
                    <a href="/profile" class="link">Назад</a>
                    <button type="submit" class="register-button">Обновить резюме</button>
                </div>
            </fieldset>
        </form>
    </div>
</body>

</html>