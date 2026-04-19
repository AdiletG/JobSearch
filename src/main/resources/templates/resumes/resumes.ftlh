<#import "../layout.ftlh" as resume>
    <@resume.layout>
        <link rel="stylesheet" href="/css/resumes.css" />
        <div class="section">

            <div class="filter">
                <form method="get" action="/resumes" class="filter-form">
                    <button type="submit" name="sort" value="createdDate,desc" class="sort-btn">По дате</button><button type="submit" name="sort" value="responsesCount,desc" class="sort-btn">По откликам</button>
                </form>
            </div>

            <#if resumes?? && resumes?has_content>
                <div class="resume-grid">
                    <#list resumes as resume>
                        <div class="resume-card">
                            <div class="resume-header">
                                <p class="1st-text">Название</p>
                                <p class="resume-title">${resume.name}</p>
                            </div>
                            <div class="resume-body">
                                <p class="2nd-text">Статус:</p>
                                <p class="resume-text">
                                    <#if resume.isActive>
                                        ACTIVE
                                        <#else>
                                            DEACTIVATE
                                    </#if>
                                </p>
                            </div>
                            <div class="resume-neck">
                            <p class="resume-date-label">Дата обновления:</p>
                            <p class="resume-date">${resume.createdDate!"Дата не указана"}</p>
                            </div>
                            <div class="resume-footer">
                                <a href="/vacancies/${resume.id}" class="btn">Go somewhere</a>
                            </div>
                        </div>
                    </#list>
                </div>
                <#else>
                    <div class="empty-state">У вас пока нет резюме</div>
            </#if>

            <footer class="footer">
                <#if page.hasPrevious()>
                    <a href="/resumes?page=${page.number-1}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                        class="prev"><</a>
                </#if>

                <#list 0..(page.totalPages-1) as i>
                    <#if i==page.number>
                        <span class="current-page-number">${i+1}</span>
                        <#else>
                            <a href="/resumes?page=${i}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                                class="page-number">${i+1}</a>
                    </#if>
                </#list>
                <#if page.hasNext()>
                    <a href="/resumes?page=${page.number+1}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                        class="next">></a>
                </#if>
            </footer>

        </div>
    </@resume.layout>