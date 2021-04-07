package com.ese.webservice.service;

import com.ese.webservice.domain.Member;
import com.ese.webservice.domain.MemberRole;

import java.util.List;

public interface MemberService {

    int save(Member member);

    Member findByMemail(String email);

    List<MemberRole> findAllByMseq(int mseq);

    int saveRole(MemberRole r);

    /*int loginCheck(Map<String, String> param);*/

}
