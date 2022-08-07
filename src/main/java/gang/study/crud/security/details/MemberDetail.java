package gang.study.crud.security.details;

import gang.study.crud.entity.Member;
import gang.study.crud.entity.MemberRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
public class MemberDetail implements UserDetails {

    private Member member;

    public MemberDetail(Member member){
        this.member = member;
    }


    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        MemberRole role = member.getMemberRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());

        Collection<GrantedAuthority> collect = new ArrayList<>();

        collect.add(authority);

        return collect;
    }
}
