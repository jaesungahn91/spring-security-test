package com.ese.webservice.service;

import com.ese.webservice.domain.Member;
import com.ese.webservice.domain.MemberRole;
import com.ese.webservice.dao.MemberRepository;
import com.ese.webservice.dao.MemberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

    @Override
    public int save(Member member) {
        int result = 0;
        if(memberRepository.save(member) != null){
            result = 1;
        }
        return result;
    }

    @Override
    public Member findByMemail(String memail) {
        return memberRepository.findByMemail(memail);
    }

    @Override
    public List<MemberRole> findAllByMseq(int mseq) {
        return memberRoleRepository.findAllByMseq(mseq);
    }

    @Override
    public int saveRole(MemberRole r) {
        int result = 0;
        if(memberRoleRepository.save(r) != null){
            result = 1;
        }
        return result;
    }

    /*    @Override
    public int loginCheck(Map<String, String> param) {
        int result = 0;
        String id = param.get("id");
        String pwd = param.get("pwd");
        try {
            Member m = memberRepository.loginCheck(id, pwd);
            if(m != null){
                result = (int)(long)m.getNo();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }*/

}
