package com.ese.webservice.domain;

import com.ese.webservice.domain.Member;
import com.ese.webservice.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SecurityMember extends User {

    private static final String ROLE_PREFIX = "ROLE_";
    private static final Long serialVersionUID = 1L;
    public String mname;
    public String ip;

    // principal에서 사용할 수 있는 값들을 정의 및 매칭
    public SecurityMember(Member member){
        super(member.getMemail(), member.getMpwd(), makeGrantedAuthority(member.getRoles()));
        this.mname = member.getMname();
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRname())));
        return list;
    }

}
