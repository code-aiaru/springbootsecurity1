package org.spring.springsecurity1.config;

import lombok.RequiredArgsConstructor;
import org.spring.springsecurity1.entity.MemberEntity;
import org.spring.springsecurity1.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override      // username 체크 -> DB에 저장되어 있는 값 (UNIQUE)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email+" << email <>>>> ");

        MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("이메일이 없습니다.");
        });

//    Optional<MemberEntity> optionalMemberEntity=memberRepository.findByEmail(email);
//    if(!optionalMemberEntity.isPresent()){
//        System.out.println("이메일이 없다. ");
//    }
//    MemberEntity memberEntity=optionalMemberEntity.get();
        System.out.println(email+" << email");
        System.out.println(memberEntity.getRole().toString()+" << getRole");


        return new MyUser(memberEntity.getEmail(),memberEntity.getPassword()
                ,memberEntity.getRole().toString());

        // 인증에 성공 하면 -> Security User에 저장
//    return User.builder()
//            .username(memberEntity.getEmail())
//            .password(memberEntity.getPassword())
//            .roles(memberEntity.getRole().toString())
//            .build()
//            ;
    }


}