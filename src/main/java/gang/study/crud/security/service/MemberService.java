package gang.study.crud.security.service;

import gang.study.crud.entity.Member;
import gang.study.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Log4j2
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        log.info("가입된 회원 비교" + findMember);
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다."); // 가입된 회원이면 예외발생
        }
    }
}
