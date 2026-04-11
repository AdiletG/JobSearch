<#import "../layout.ftlh" as resume>
<@resume.layout>
    <link rel="stylesheet" href="/css/resumes.css" />
    <div class="section">
     <#if resumes?? && resumes?has_content>
    <div class="resume-grid">
        <#list resumes as resume>
            <div class="resume-card">
                <h5 class="resume-title">${resume.name}</h5>
                <p class="card-text">
                    Статус:
                    <#if resume.isActive>
                        ACTIVE
                    <#else>
                        DEACTIVATE
                    </#if>
                </p>
                <div class="resume-date-label">Дата обновления:</div>
                <p class="card-footer">${resume.createdDate!"Дата не указана"}</p>
                <div class="resume-actions">
                    <a href="/vacancies/${resume.id}" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </#list>
    </div>
     <#else>
         <div class="empty-state">У вас пока нет резюме</div>
     </#if>
    </div>
</@resume.layout>