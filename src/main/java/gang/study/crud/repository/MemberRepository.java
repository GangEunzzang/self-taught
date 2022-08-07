package gang.study.crud.repository;

import gang.study.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByEmail(String email); // 이메일 중복검사

}