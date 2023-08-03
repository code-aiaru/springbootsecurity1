package org.spring.springsecurity1;

import org.junit.jupiter.api.Test;
import org.spring.springsecurity1.constraint.Role;
import org.spring.springsecurity1.constrant.Role;
import org.spring.springsecurity1.dto.MemberDto;
import org.spring.springsecurity1.entity.MemberEntity;
import org.spring.springsecurity1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

//  @Autowired
//  private PasswordEncoder passwordEncoder;

    @Test
    void insert() {
        // form
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail("admin@mail.com");
        memberDto.setPassword("2222");
        memberDto.setRole(Role.ADMIN);
//    //1.
//    MemberEntity memberEntity
//            = MemberEntity.toMemberEntity(memberDto,passwordEncoder);
        //2.
        MemberEntity memberEntity1=  MemberEntity.builder()
                .email(memberDto.getEmail())
//            .password(passwordEncoder.encode(memberDto.getPassword()))
                .password(memberDto.getPassword())
                .role(memberDto.getRole())
                .build();

        String email= memberRepository.save(memberEntity1).getEmail();

//     Optional<MemberEntity> optionalMemberEntity= memberRepository.findByEmail(email);
//     if(optionalMemberEntity.isPresent()){
//        MemberEntity memberEntity3= optionalMemberEntity.get();
//     }

        MemberEntity memberEntity2= memberRepository.findByEmail(email).orElseThrow(()->{
            throw  new IllegalArgumentException("이메일 없습니다.");
        });

//    MemberEntity memberEntity4= memberRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);





    }
}