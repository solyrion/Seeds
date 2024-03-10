package assignment.hello.repository;

import assignment.hello.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpringRepository extends JpaRepository<Member, Long> {

    Member findByNameLike(String memberName);
    List<Member> findByAgeLessThanEqual(Integer age);

}
