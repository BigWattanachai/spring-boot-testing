package com.example.testingdemo.repository;

import com.example.testingdemo.entity.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    public void testFindByName() throws InterruptedException {
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
