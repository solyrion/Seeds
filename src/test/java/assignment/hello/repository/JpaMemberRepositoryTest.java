package assignment.hello.repository;

import assignment.hello.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemberRepositoryTest {

    @Autowired
    JpaMemberRepository repository;

    @Test
    void saveMember(){
        Member member = new Member("memberA", 20, "seoul");
        Member savedMember = repository.save(member);
        assertThat(savedMember).isSameAs(member);
    }

    @Test
    void updateMember(){
        Member member = new Member("memberA", 20, "seoul");
        Member savedMember = repository.save(member);
        Long memberId = savedMember.getId();

        Member updateMember = new Member("memberB", 25, "london");
        repository.update(memberId, updateMember);

        Member findMember = repository.findById(memberId).get();
        assertThat(findMember.getName()).isEqualTo(updateMember.getName());
        assertThat(findMember.getAge()).isEqualTo(updateMember.getAge());
        assertThat(findMember.getAddress()).isEqualTo(updateMember.getAddress());
    }

    @Test
    void findMemberWithName(){
        Member memberA = new Member("memberA", 20, "seoul");
        Member memberB = new Member("memberB", 30, "london");

        repository.save(memberA);
        repository.save(memberB);

        Member findMember = repository.findByName("memberA");
        assertThat(findMember).isEqualTo(memberA);
    }

    @Test
    void findMemberWithAge(){
        Member memberA = new Member("memberA", 20, "seoul");
        Member memberB = new Member("memberB", 30, "london");

        repository.save(memberA);
        repository.save(memberB);

        List<Member> findMembers = repository.findByAge(30);

        assertThat(findMembers).contains(memberA);
        assertThat(findMembers).contains(memberB);

        List<Member> findMembers2 = repository.findByAge(20);
        assertThat(findMembers2).containsOnly(memberA);
    }

    @Test
    void deleteMember(){
        Member member = new Member("memberA", 20, "seoul");
        repository.save(member);
        Long memberId = member.getId();
        repository.delete(memberId);
        assertThatThrownBy(() -> repository.findById(memberId).orElseThrow())
                .isInstanceOf(NoSuchElementException.class);
    }
    

}