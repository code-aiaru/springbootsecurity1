package org.spring.springsecurity1.entity;

import lombok.*;
import org.spring.springsecurity1.constraint.Role;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sec_member1")
public class MemberEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email; // 이메일 *** // Spring Security의 UserName을 대체한다

    @Column(nullable = false)
    private String password; // 비밀번호 *** (추후비밀번호 암호화)

    @Enumerated(EnumType.STRING)
    private Role role; // 권한 ***



}
