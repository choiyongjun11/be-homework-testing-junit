package com.springboot.member.repository;

import com.springboot.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveMemberTest() {
        //given
        Member member = new Member();
        member.setEmail("lucky@cat.house");
        member.setName("김러키러키");
        member.setPhone("010-0000-1111");

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertThat(savedMember, is(notNullValue()));
        assertThat(savedMember.getEmail(), is(member.getEmail()));
        assertThat(savedMember.getName(), is(member.getName()));
        assertThat(savedMember.getPhone(), is(member.getPhone()));
    }

    @Test
    void findByEmailTest() {
        //given
        Member member = new Member();
        member.setEmail("lucky@google.com");
        member.setPhone("010-0000-0000");
        member.setName("김러키");

        memberRepository.save(member);
        //when
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());

        //then
        assertThat(findMember.isPresent(), is(true));
        Member actualMember = findMember.get();
        assertThat(actualMember.getEmail(), is(member.getEmail()));
        assertThat(actualMember.getEmail(), is(member.getName()));
        assertThat(actualMember.getEmail(), is(member.getPhone()));
    }
}