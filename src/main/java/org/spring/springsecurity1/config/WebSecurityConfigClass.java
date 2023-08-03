package org.spring.springsecurity1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfigClass {

    // 권한 설정, 접근 페이지 , 로그인, 로그아웃
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // POST-> 웹 보안 공격 차단
        http.csrf().disable();// POST-> 웹페이지 보안 공격
        // 웹페이지 별 -> 요청에 대한 페이지 설정
        // 모든 사용자 접근 가능
        http.authorizeHttpRequests()
                // 모든 사용자 접근 권한 허용
                .antMatchers("/","/member/login","/member/join","/shop/**" ,"/member/loginFail").permitAll()
                // 모든 사용자 접근 권한 허용
                .antMatchers("/css/**","/images/**","/js/**").permitAll()
                // 로그인후 이용 -> 권한 설정하고 상관 없이 로그인만 인증되면 접속가능
                .antMatchers("/member/logOut","/member/loginOk").authenticated()
                // 일반페이지(MEMBER,MANAGER,ADMIN) -> MEMBER
                .antMatchers("/member/memberShip/**").hasAnyRole("MEMBER","MANAGER","ADMIN")
                // 중간관리페이지(MANAGER,ADMIN) -> MANAGER
                .antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
                // 최고관리자
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
        ;
        // 로그인 설정
        http.formLogin()
                // 사용자가 로그인 요청시 가로채서 security login페이지
                .loginPage("/member/login")
                // 로그인시 아이디
                .usernameParameter("email")
                // 로그인 성공시
                .defaultSuccessUrl("/")
                //실제 form에서 로그인을 실행 POST
                .loginProcessingUrl("/member/login")
                // 로그인 성공시 url
                .defaultSuccessUrl("/")
//            .failureHandler(customFailHandler)                  //실패시 핸들러
                // 로그인 실패시 url

                .failureForwardUrl("/member/loginFail")
        ;
        // 로그아웃
        http.logout()
                // 개발자가 로그아웃을 설정 할수 있다.
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logOut"))
                .logoutSuccessUrl("/")
//            .logoutSuccessUrl("/member/logOutOk")
        ;


        return http.build();
    }




    // 비빌번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}