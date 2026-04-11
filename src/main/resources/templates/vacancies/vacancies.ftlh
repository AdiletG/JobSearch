<#import "../layout.ftlh" as vacancy>
    <@vacancy.layout>
        <link rel="stylesheet" href="/css/vacancies.css" />
        <div class="section">
            <#if vacancies?? && vacancies?has_content>
                <div class="resume-grid">
                <#list vacancies as vacancy>
                    <div class="resume-card">
                        <h5 class="resume-title">${vacancy.name}</h5>
                        <p class="card-text">
                            Статус:
                            <#if vacancy.isActive>
                                ACTIVE
                                <#else>
                                    DEACTIVATE
                            </#if>
                        </p>
                        <div class="resume-date-label">Дата обновления:</div>
                        <p class="card-footer">${vacancy.createdDate!"Дата не указана"}</p>
                        <div class="resume-actions">
                            <a href="/vacancies/${vacancy.id}" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </#list>
                </div>

                <#else>
                    <div class="text-center my-4">
                        Вакансий пока нет
                    </div>
            </#if>
        </div>

    </@vacancy.layout>