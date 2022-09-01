package gang.study.crud.entity;


import gang.study.crud.dto.MemberDTO;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
public class Member {

    @Id
    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    public Member(String email, String password, String name, MemberRole role){
        this.email = email;
        this.password = password;
        this.name = name;
        this.memberRole = role;
    }

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
