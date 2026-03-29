package kg.job.jobsearch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final DataSource dataSource;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        String userQuery = """
                select email, password, enabled from users
                where email = ?
                """;
        String authQuery = """
                select u.email, auth.authority
                from authorities auth
                inner join role_auth ra on auth.id = ra.auth_id
                inner join roles r on ra.role_id = r.id
                inner join user_role ur on r.id = ur.role_id
                inner join users u on ur.user_id = u.id
                where u.email = ?
                """;
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(authQuery);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.GET,"/vacancies/**").hasAuthority("VACANCY_VIEW")
                        .requestMatchers(HttpMethod.GET, "/resumes/**").hasAuthority("RESUME_VIEW")
                        .requestMatchers(HttpMethod.GET, "/respond/**").hasAuthority("RESPONDED_APPLICANTS_VIEW")
                        .requestMatchers(HttpMethod.GET, "/categories/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/vacancies/**").hasAuthority("VACANCY_CREATE")
                        .requestMatchers(HttpMethod.POST, "/resumes/**").hasAuthority("RESUME_CREATE")
                        .requestMatchers(HttpMethod.POST, "/respond/**").hasAuthority("RESPOND_TO_VACANCY")

                        .requestMatchers(HttpMethod.PATCH, "/vacancies/**").hasAuthority("VACANCY_UPDATE")
                        .requestMatchers(HttpMethod.PATCH, "/resumes/**").hasAuthority("RESUME_UPDATE")
                        .requestMatchers(HttpMethod.PATCH, "/users/**").hasAuthority("PROFILE_EDIT")

                        .requestMatchers(HttpMethod.DELETE, "/vacancies/**").hasAuthority("VACANCY_DELETE")
                        .requestMatchers(HttpMethod.DELETE, "/resumes/**").hasAuthority("RESUME_DELETE")
                        .anyRequest().authenticated()
                );


        return http.build();
    }
}