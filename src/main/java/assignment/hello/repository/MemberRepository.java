package assignment.hello.repository;

import assignment.hello.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    public Member save(Member member);

    public void update(Long itemId, Member member);

    public Optional<Member> findById(Long id);

    public Member findByName(String memberName);

    public List<Member> findByAge(Integer age);

    public void delete(Long id);
}
