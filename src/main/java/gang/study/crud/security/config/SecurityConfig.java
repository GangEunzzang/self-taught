package gang.study.crud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 해당 경로는 security 가 무시하게 설정
        web.ignoring().antMatchers("/js/**","/css/**","/images/**","/font/**","/html/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN") // /admin은 admin권한만 접근 가능
                .antMatchers("/**").permitAll() // 모든 경로에 권한없이 접근 가능
                .and()
                .formLogin() // form 로그인 기반으로 인증 설정
                .loginPage("/login") // 로그인 페이지 위치
                .usernameParameter("email") // default : username 이므로 내 entity에 맞게 변경
                .passwordParameter("password") // password 값 등록 default : password

                // AuthenticationManager 란?
                .loginProcessingUrl("/perform") // action에 동일한 url적용시 AuthenticationManager 상속 구현
                .defaultSuccessUrl("/list") // 로그인 성공시 페이지
                .failureUrl("/login/fail") // 로그인 실패
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout") // 로그아웃 성공시 연결되는 페이지
                .invalidateHttpSession(true) // 로그아웃시 세션 날림
                .and()
                .exceptionHandling().accessDeniedPage("/denied");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public LoginService loginService() {
//        return new LoginService();
//    }
}