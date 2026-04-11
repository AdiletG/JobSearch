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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
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
                    <a href="/" class="nav-link ${(currentPage == 'home')?then('active', '')}">
                        Главная
                    </a>

                    <#if user?? && user.accountType?string=="APPLICANT">
                        <a href="/vacancies" class="nav-link ${(currentPage == 'vacancies')?then('active', '')}">
                            Вакансии
                        </a>
                        <#elseif user?? && user.accountType?string=="EMPLOYER">
                            <a href="/resumes" class="nav-link ${(currentPage == 'resumes')?then('active', '')}">
                                Резюме
                            </a>
                    </#if>

<#--                    <a href="/responses" class="nav-link ${(currentPage == 'responses')?then('active', '')}">-->
<#--                        Отклики-->
<#--                    </a>-->

<#--                    <a href="/settings" class="nav-link ${(currentPage == 'settings')?then('active', '')}">-->
<#--                        Настройки-->
<#--                    </a>-->
                </nav>

                <div class="navbar-right">
<#--                    <button class="icon-btn" type="button">💬</button>-->

<#--                    <button class="icon-btn" type="button">-->
<#--                        🔔-->
<#--                        <span class="icon-badge">5</span>-->
<#--                    </button>-->

                    <div class="profile-mini">
                        <a href="/profile" class="nav-link ${(currentPage == 'profile')?then('active', '')}">
                            Профиль
                        </a>
                    </div>

                    <div class="exit-box">
                        <form action="/auth/logout" method="post">
                            <button type="submit" class="exit">Выйти</button>
                        </form>
                    </div>

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