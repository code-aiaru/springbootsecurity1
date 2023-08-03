package org.spring.springsecurity1.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springsecurity1.constrant.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {

    private Long id;

    private String email;  // 이메일  ***   User -> username  대체

    private String password; //비빌번호 -> 비빌번호 암호화  ***

    private Role role;      // 권한 설정  ***

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}