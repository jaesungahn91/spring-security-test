package com.ese.webservice.web.member;

import com.ese.webservice.domain.Member;
import com.ese.webservice.domain.MemberRole;
import com.ese.webservice.service.MemberService;
import com.ese.webservice.domain.SecurityMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 *  Member Controller
 *  ----------------
 *  spring security
 *  jpa
 *  jwt
 *  rsa
 *  logback
 *  ----------------
 */
@Controller
public class MemberController {


    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    MemberService memberService;

    /**
     * Member 추가
     * @param member
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create(Member member, @RequestParam(value = "role") String role){
        // 패스워드 암호화 및 DB등록
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        member.setMpwd(pe.encode(member.getMpwd()));
        memberService.save(member);

        // 룰 등록
        MemberRole r = new MemberRole();
        r.setRname(role);
        r.setMseq((int)(long)member.getMseq());
        member.setRoles(Arrays.asList(r));
        memberService.saveRole(r);

        // SecurityContextHolder에서 Context를 받아 인증 설정
        SecurityMember userDetails = new SecurityMember(member);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/user";
    }

    /**
     * Login 페이지 이동
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "user/login";
    }

    /**
     * Home으로 이동
     * @return
     */
    @RequestMapping(value = {"/home", "/"})
    public String home(){
        return "home";
    }

    /**
     * 회원가입으로 이동
     * @return
     */
    @RequestMapping(value = "/registerForm")
    public String register(){
        return "user/registerForm";
    }

    /**
     * User페이지 이동
     * @return
     */
    @RequestMapping(value = "/user")
    public String user(){
        return "user/user";
    }

    /**
     * 403에러 페이지 핸들러
     * @return
     * jsp로 변경예정
     */
    @RequestMapping(value = "/403")
    @ResponseBody
    public String page403(){
        return "접근이 거부되었습니다.";
    }

    /**
     * 테스트
     * @param securityMember
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(@AuthenticationPrincipal SecurityMember securityMember){

        StringBuffer sb = new StringBuffer();

        if(securityMember != null){
            sb.append(securityMember.getMname()).append(" : ").append(securityMember.getIp());
        }
        logger.info(sb.toString());

        return sb.toString();
    }
}
