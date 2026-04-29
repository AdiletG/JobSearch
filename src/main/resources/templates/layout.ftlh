<#macro layout>

    <!doctype html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>
        <link rel="stylesheet" href="/css/navbar.css">
        <title>JobSearch</title>
    </head>

    <body>

        <header class="navbar">
            <div class="navbar-container">
                <div class="navbar-left">
                    <a href="/" class="logo">
                        <img src="/logo/logo.png" class="logo-img" alt="logo">
                    </a>
                </div>

                <nav class="navbar-center">

                    <#if user?? && user.accountType?string=="APPLICANT">
                        <a href="/vacancies" class="nav-link ${(currentPage == 'vacancies')?then('active', '')}">
                            Вакансии
                        </a>
                        <#elseif user?? && user.accountType?string=="EMPLOYER">
                            <a href="/resumes" class="nav-link ${(currentPage == 'resumes')?then('active', '')}">
                                Резюме
                            </a>
                    </#if>

                    <#-- <a href="/responses" class="nav-link ${(currentPage == 'responses')?then('active', '')}">-->
                        <#-- Отклики-->
                            <#-- </a>-->

                                <#-- <a href="/settings"
                                    class="nav-link ${(currentPage == 'settings')?then('active', '')}">-->
                                    <#-- Настройки-->
                                        <#-- </a>-->
                </nav>

                <div class="navbar-right">
                    <#if user??>
                        <a href="/profile" class="profile-mini ${(currentPage == 'profile')?then('active', '')}">
                            <#if user?? && user.avatar??>
                                <img src="/images/${user.avatar}" alt="Profile avatar" class="profile-avatar">
                                <#else>
                                    <img src="/logo/profile.png" alt="Default profile" class="profile-avatar">
                            </#if>
                        </a>

                        <div class="exit-box">
                            <form action="/auth/logout" method="post">

                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                        value="${(_csrf.token)!'csrf-token'}">
                                </#if>
                                
                                <button type="submit" class="exit">Выйти</button>
                            </form>
                        </div>

                        <#else>
                            <a href="/auth/login" class="login">Войти</a>
                            <a href="/auth/register" class="login">Регистрация</a>
                    </#if>



                    <button class="mobile-menu-btn" type="button">☰</button>
                </div>
            </div>
        </header>

        <main class="page-content container">
            <#nested>
        </main>

    </body>

    </html>

</#macro>