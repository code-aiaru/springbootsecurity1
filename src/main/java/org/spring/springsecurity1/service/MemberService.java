package org.spring.springsecurity1.service;

import lombok.RequiredArgsConstructor;
import org.spring.springsecurity1.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

}