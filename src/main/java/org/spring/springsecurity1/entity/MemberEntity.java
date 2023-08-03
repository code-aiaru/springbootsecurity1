package org.spring.springsecurity1.entity;

import lombok.*;
import org.spring.springsecurity1.constrant.Role;
import org.spring.springsecurity1.dto.MemberDto;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "sec_member1")
public class MemberEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;  // 이메일  ***   User -> username  대체

    @Column(nullable = false)
    private String password; //비빌번호 -> 비빌번호 암호화  ***

    @Enumerated(EnumType.STRING)
    private Role role;      // 권한 설정  ***


    public static MemberEntity toMemberEntity(MemberDto memberDto,
                                              PasswordEncoder passwordEncoder) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDto.getEmail());
        memberEntity.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberEntity.setRole(memberDto.getRole());
        return memberEntity;
    }
}