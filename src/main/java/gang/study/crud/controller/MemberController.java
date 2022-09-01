package gang.study.crud.controller;

import gang.study.crud.dto.MemberDTO;
import gang.study.crud.entity.Member;
import gang.study.crud.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping(value = "/new")
    public String memberForm(Model model){
        model.addAttribute("memberDTO", new MemberDTO());
        return "/memberForm";
    }

    @PostMapping(value = "/new")
    public String memberForm(MemberDTO memberDTO) {
        Member member = Member.createMember(memberDTO, passwordEncoder);

        log.info("멤버" + memberDTO);
        memberService.saveMember(member);

        return "redirect:/list";
    }

    @GetMapping(value = "/join")
    public String login() {
        return "/join";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/join";
    }

}
