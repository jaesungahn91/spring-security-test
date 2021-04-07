package com.ese.webservice.dao;

import com.ese.webservice.domain.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {

    List<MemberRole> findAllByMseq(int mseq);

}
