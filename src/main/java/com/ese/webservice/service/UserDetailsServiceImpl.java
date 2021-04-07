package com.ese.webservice.service;

import com.ese.webservice.domain.Member;
import com.ese.webservice.domain.MemberRole;
import com.ese.webservice.domain.SecurityMember;
import com.ese.webservice.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String memail) throws UsernameNotFoundException {
        Member member = memberService.findByMemail(memail);

        if(member == null){
            throw new UsernameNotFoundException(memail);
        }else{
            member.setRoles(memberService.findAllByMseq((int)(long)member.getMseq()));
            logger.info("================= Roles - "+ memail +" ==================");
            for(MemberRole r : member.getRoles()){
                logger.info(r.getRname());
            }
        }

        return new SecurityMember(member);
    }
}
