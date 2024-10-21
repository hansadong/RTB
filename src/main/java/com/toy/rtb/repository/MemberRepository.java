package com.toy.rtb.repository;

import com.toy.rtb.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberId(String memberId);

    Member getMemberByMemberId(String memberId);
}
