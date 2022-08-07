package gang.study.crud.security.details;

import gang.study.crud.entity.Member;
import gang.study.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberDetailsServiceImpl implements UserDetailsService { //DB에 있는 유저 정보를 이용할때 사용

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username);
        if(member == null) {
            throw new UsernameNotFoundException(username); // 유저가 없다면 ?

        }
        log.info("id 정보값은"+ member);  // member에 회원 정보가 들어있다
        return new MemberDetail(member); // 있다면 MemberDetail로 변환 후 반환
    }
}
