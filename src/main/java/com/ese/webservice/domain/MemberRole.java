package com.ese.webservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@EqualsAndHashCode(of = "rseq")
public class MemberRole {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //private Long rno;
   private Long rseq;

   //private String roleName;
   private String rname;

   //private int uid;
   private int mseq;

}
