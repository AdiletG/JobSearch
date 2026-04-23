<#import "../layout.ftlh" as vacancy>
    <@vacancy.layout>
        <link rel="stylesheet" href="/css/vacancies.css" />
        <div class="section">

            <div class="filter">
                <form method="get" action="/vacancies" class="filter-form">
                    <button type="submit" name="sort" value="createdDate,desc" class="sort-btn">По дате</button><button
                        type="submit" name="sort" value="responsesCount,desc" class="sort-btn">По откликам</button>
                </form>
            </div>

            <#if vacancies?? && vacancies?has_content>
                <div class="resume-grid">
                    <#list vacancies as vacancy>
                        <a href="/vacancies/${vacancy.id}" class="btn resume-card ">
                            <div class="resume-header">
                                <p class="1st-text">Название</p>
                                <p class="resume-title">${vacancy.name}</p>
                            </div>
                            <div class="resume-body">
                                <p class="2nd-text">Заработная плата:</p>
                                <p class="resume-text">${vacancy.salary}</p>
                            </div>
                            <div class="resume-neck">
                                <p class="resume-date-label">Дата обновления:</p>
                                <p class="resume-date">${vacancy.createdDate!"Дата не указана"}</p>
                            </div>
                            <div class="resume-footer">
                                <p class="3rd-text">Категория</p>

                                ${vacancy.author.name}

                                <!-- <#if vacancy.category?has_content>
                                    <p class="resume-cetogory">${vacancy.category.name}</p>
                                    <#else>
                                        <p class="resume-cetogory">-</p>
                                </#if> -->
                            </div>
                        </a>
                    </#list>
                </div>

                <#else>
                    <div class="text-center my-4">
                        Вакансий пока нет
                    </div>
            </#if>

            <footer class="footer">
                <#if page.hasPrevious()>
                    <a href="/vacancies?page=${page.number-1}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                        class="prev">
                        <</a>
                </#if>

                <#list 0..(page.totalPages-1) as i>
                    <#if i==page.number>
                        <span class="current-page-number">${i+1}</span>
                        <#else>
                            <a href="/vacancies?page=${i}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                                class="page-number">${i+1}</a>
                    </#if>
                </#list>
                <#if page.hasNext()>
                    <a href="/vacancies?page=${page.number+1}&size=${page.size}&sort=${sort!''}&categoryId=${categoryId!''}"
                        class="next">></a>
                </#if>
            </footer>

        </div>

    </@vacancy.layout>