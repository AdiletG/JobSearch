<#import "../layout.ftlh" as resume>
    <@resume.layout>
        <link rel="stylesheet" href="/css/resumes.css" />
        <div class="section">

            <div class="filter">
                <p class="filter-text">Сортировка</p>
                <form method="get" action="/resumes" id="sortForm" class="filter-form">
                    <select name="sort" onchange="document.getElementById('sortForm').submit()" class="sort-select">
                        <option value="createdDate,desc" class="sort-btn" <#if sort?? && sort=="createdDate,desc">
                            selected</#if>>По дате
                        </option>
                        <option value="responsesCount,desc" class="sort-btn" <#if sort?? && sort=="responsesCount,desc">
                            selected</#if>>По
                            откликам</option>
                    </select>
                </form>
            </div>

            <#if resumes?? && resumes?has_content>
                <div class="resume-grid">
                    <#list resumes as resume>
                        <a href="/vacancies/${resume.id}" class="btn resume-card">
                            <div class="resume-header">
                                <p class="1st-text">Название</p>
                                <p class="resume-title">${resume.name}</p>
                            </div>
                            <div class="resume-body">
                                <p class="2nd-text">Заработная плата:</p>
                                <p class="resume-text">${resume.salary}</p>
                            </div>
                            <div class="resume-neck">
                                <p class="resume-date-label">Дата обновления:</p>
                                <p class="resume-date">${resume.createdDate!"Дата не указана"}</p>
                            </div>
                            <div class="resume-footer">
                                <p class="3rd-text">Категория</p>

                                ${resume.applicant.name}

                                <!-- <#if resume.category?has_content>
                                    <p class="resume-cetogory">${resume.category.name}</p>
                                    <#else>
                                        <p class="resume-cetogory">-</p>
                                </#if> -->

                            </div>
                        </a>
                    </#list>
                </div>
                <#else>
                    <div class="empty-state">У вас пока нет резюме</div>
            </#if>

            <footer class="footer">
                <#if page.hasPrevious()>
                    <a href="/resumes?page=${page.number-1}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                        class="prev">
                        <</a>
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