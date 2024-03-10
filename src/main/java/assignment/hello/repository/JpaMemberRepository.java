package assignment.hello.repository;

import assignment.hello.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JpaMemberRepository implements MemberRepository{

    private final SpringRepository repository;

    public JpaMemberRepository(SpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public void update(Long memberId, Member paramMember) {
        Member findMember = repository.findById(memberId).orElseThrow();
        findMember.setName(paramMember.getName());
        findMember.setAge(paramMember.getAge());
        findMember.setAddress(paramMember.getAddress());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Member findByName(String memberName) {
        return repository.findByNameLike(memberName);
    }

    @Override
    public List<Member> findByAge(Integer age) {
        return repository.findByAgeLessThanEqual(age);
    }

    @Override
    public void delete(Long id) {
        Member findMember = repository.findById(id).orElseThrow();
        repository.delete(findMember);
    }

}
