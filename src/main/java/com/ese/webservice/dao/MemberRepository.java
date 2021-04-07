package com.ese.webservice.dao;

import com.ese.webservice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /*@Query(value = "SELECT * FROM MEMBER WHERE id = :id AND pwd = :pwd", nativeQuery = true)
    Member loginCheck(@Param(value = "id") String id, @Param(value = "pwd") String pwd);*/

    Member findByMemail(String memail);

}
