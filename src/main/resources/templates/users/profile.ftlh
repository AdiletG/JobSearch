<#import "../layout.ftlh" as profile>
    <@profile.layout>
        <link rel="stylesheet" href="/css/profile.css" />

        <#if user?? && user.accountType?string=="EMPLOYER">
            <div class="page">
                <div class="profile-wrapper">
                    <div class="profile-cover"></div>
                    <div class="profile-header">
                        <div class="profile-main">
                            <div class="profile-left">
                                <div class="avatar">
                                    <img src="${user.avatar}" class="logo" alt="logo">
                                </div>
                                <div class="user-info">
                                    <h1 class="user-name">${user.name} ${user.surname}</h1>
                                    <div class="user-meta">Возраст: ${user.age}</div>
                                    <div class="btn-row">
                                        <a href="/profile/update" class="btn btn-primary">Редактировать профиль</a>
                                    </div>
                                </div>
                            </div>
                            <div class="header-actions">
                                <a href="/vacancies/create" class="action-card create">Создать вакансию</a>
                                <div class="action-card responses">
                                    <span>Отклики</span>
                                    <div class="badge">5</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="section">
                        <h2 class="section-title">Вакансии</h2>
                        <#if vacancies?? && vacancies?has_content>
                            <div class="resume-grid">
                                <#list vacancies as vacancy>
                                    <div class="resume-card">
                                        <div class="resume-title">${vacancy.name}</div>
                                        <div class="resume-date-label">Дата обновления:</div>
                                        <div class="resume-date">${vacancy.createdDate}</div>
                                        <div class="resume-actions">
                                            <a href="/vacancies/update/${vacancy.id}"
                                                class="btn btn-outline-blue">Обновить</a>

                                            <form action="/vacancies/delete/${vacancy.id}" method="post">
                                                <button type="submit" class="delete">Удалить</button>
                                            </form>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                            <#else>
                                <div class="empty-state">У вас пока нет вакансий</div>
                        </#if>
                    </div>
                    <div class="footer-note"></div>
                </div>
            </div>

            <#elseif user?? && user.accountType?string=="APPLICANT">
                <div class="page">
                    <div class="profile-wrapper">
                        <div class="profile-cover"></div>
                        <div class="profile-header">
                            <div class="profile-main">
                                <div class="profile-left">
                                    <div class="avatar">
                                        <img src="${user.avatar}" class="logo" alt="logo">
                                    </div>
                                    <div class="user-info">
                                        <h1 class="user-name">${user.name} ${user.surname}</h1>
                                        <div class="user-meta">Возраст: ${user.age}</div>
                                        <div class="btn-row">
                                            <button class="btn btn-primary">Редактировать профиль</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="header-actions">
                                    <div class="action-card create"><span>+ Создать резюме</span></div>
                                    <div class="action-card responses">
                                        <span>Отклики</span>
                                        <div class="badge">5</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="section">
                            <h2 class="section-title">Резюме</h2>
                            <#if resumes?? && resumes?has_content>
                                <div class="resume-grid">
                                    <#list resumes as resume>
                                        <div class="resume-card">
                                            <div class="resume-title">${resume.name}</div>
                                            <div class="resume-date-label">Дата обновления:</div>
                                            <div class="resume-date">${resume.createdDate}</div>
                                            <div class="resume-actions">
                                                <button class="btn btn-outline-blue">Обновить</button>
                                                <button class="btn btn-outline-green">Ред.</button>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                                <#else>
                                    <div class="empty-state">У вас пока нет резюме</div>
                            </#if>
                        </div>
                        <div class="footer-note"></div>
                    </div>
                </div>

        </#if>
    </@profile.layout>