package gang.study.crud.service;

import gang.study.crud.dto.MemberDTO;
import gang.study.crud.entity.Member;
import gang.study.crud.security.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceTests {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail("test@gmail.com");
        memberDTO.setName("이강은");
        memberDTO.setPassword("1234");
        return Member.createMember(memberDTO, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getMemberRole(), savedMember.getMemberRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMember() {
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);

        Throwable e =assertThrows(IllegalStateException.class, () ->{
            memberService.saveMember(member2);
        });
        assertEquals("이미 가입된 회원입니다.", e.getMessage());

    }
}
