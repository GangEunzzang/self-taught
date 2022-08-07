package gang.study.crud.entity;


import gang.study.crud.dto.MemberDTO;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder){

        Member member = new Member();
        member.setEmail(memberDTO.getEmail());;
        member.setName(memberDTO.getName());
        String password = passwordEncoder.encode(memberDTO.getPassword());
        member.setPassword(password);
        member.setMemberRole(MemberRole.USER);
        return member;
    }


}
