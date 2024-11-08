package com.toy.rtb.repository.member;

import com.toy.rtb.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberId(String memberId);

    Member getMemberByMemberId(String memberId);

    Member getMemberByNickName(String nickName);
}
