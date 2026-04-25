package kg.job.jobsearch.common;

import jakarta.servlet.http.HttpServletRequest;

public class UrlBuilder {
    private UrlBuilder() {
    }

    public static String getSiteUrl(HttpServletRequest request){
        String siteUrls = request.getRequestURL().toString();
        return siteUrls.replace(request.getServletPath(), "");
    }
}