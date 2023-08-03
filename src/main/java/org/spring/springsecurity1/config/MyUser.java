package org.spring.springsecurity1.config;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter                  // Spring 관리  객체
public class MyUser extends User {

    private String email;
    private String password;
    private String role;
    public MyUser(String email, String password, String role) {
        super(email, password, AuthorityUtils.createAuthorityList("ROLE_"+role));
        //ROLE_ADMIN,ROLE_MANAGER,ROLE_MEMBER

        this.email=email;
        this.password=password;
        this.role=role;
    }


}