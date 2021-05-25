package com.example.jpa2.service;

import com.example.jpa2.Dto.Member;
import com.example.jpa2.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{
        //give
        Member member = new Member();
        member.setName("Kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));

    }


    @Test
    public void 중복() throws Exception{
        //give
        Member member1 = new Member();
        member1.setName("Park");
        Member member2 = new Member();
        member2.setName("Park");

        //when
        memberService.join(member1);

        try {
            memberService.join(member2);
        }catch (IllegalStateException e) {
            return;
        }

        //than
        fail("fail");
    }






















}