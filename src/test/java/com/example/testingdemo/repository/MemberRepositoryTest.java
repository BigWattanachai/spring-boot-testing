package com.example.testingdemo.repository;

import com.example.testingdemo.entity.Member;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @After
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        //Arrange
        Member member = new Member();
        member.setName("Cherprang");
        entityManager.persist(member);

        //Act
        Optional<Member> memberOptional = memberRepository.findByName("Cherprang");

        //Assert
        assertThat(memberOptional.get().getName()).isEqualTo("Cherprang");
    }
}
