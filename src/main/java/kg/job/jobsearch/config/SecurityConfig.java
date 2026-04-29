package kg.job.jobsearch.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

import java.io.IOException;
import java.util.Set;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .formLogin(login -> login
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .failureUrl("/auth/login?error=true")
                        .permitAll()
                        .successHandler(customSuccessHandler()))
                .logout(logout -> logout
                        .logoutRequestMatcher(PathPatternRequestMatcher.withDefaults().matcher("/auth/logout"))
                       .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
                        .permitAll())
                .httpBasic(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            request.setAttribute("status", HttpStatus.FORBIDDEN.value());
                            request.setAttribute("reason", "Доступ запрещен " + accessDeniedException.getMessage());
                            request.setAttribute("details", request);
                            request.getRequestDispatcher("/errors/error").forward(request, response);
                        }))
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.GET,"/vacancies").hasAuthority("VACANCY_VIEW")
                        .requestMatchers(HttpMethod.GET, "/resumes").hasAuthority("RESUME_VIEW")
                        .requestMatchers(HttpMethod.GET, "/respond/**").hasAuthority("RESPONDED_APPLICANTS_VIEW")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasAuthority("USER_MANAGE")
                        .requestMatchers(HttpMethod.GET, "/profile/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/categories/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/vacancies/create").hasAuthority("VACANCY_CREATE")
                        .requestMatchers(HttpMethod.POST, "/vacancies/update/**").hasAuthority("VACANCY_UPDATE")
                        .requestMatchers(HttpMethod.POST, "/vacancies/delete/**").hasAuthority("VACANCY_DELETE")
                        .requestMatchers(HttpMethod.POST, "/resumes/create").hasAuthority("RESUME_CREATE")
                        .requestMatchers(HttpMethod.POST, "/resumes/update/**").hasAuthority("RESUME_UPDATE")
                        .requestMatchers(HttpMethod.POST, "/resumes/delete/**").hasAuthority("RESUME_DELETE")
                        .requestMatchers(HttpMethod.POST, "/respond/**").hasAuthority("RESPOND_TO_VACANCY")
                        .requestMatchers(HttpMethod.POST, "/users/**").permitAll()

                        .requestMatchers(HttpMethod.PATCH, "/vacancies/**").hasAuthority("VACANCY_UPDATE")
                        .requestMatchers(HttpMethod.PATCH, "/resumes/**").hasAuthority("RESUME_UPDATE")
                        .requestMatchers(HttpMethod.PATCH, "/users/**").hasAuthority("PROFILE_EDIT")

                        .requestMatchers(HttpMethod.DELETE, "/vacancies/**").hasAuthority("VACANCY_DELETE")
                        .requestMatchers(HttpMethod.DELETE, "/resumes/**").hasAuthority("RESUME_DELETE")
                        .anyRequest().permitAll()
                );


        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler(){
        return (request, response, authentication) -> {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            if(roles.contains("ROLE_APPLICANT")){
                response.sendRedirect("/vacancies");
            } else if (roles.contains("ROLE_EMPLOYER")) {
                response.sendRedirect("/resumes");
            }else {
                response.sendRedirect("/");
            }
        };
    }
}