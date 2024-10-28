package com.toy.rtb.service.member;

import com.toy.rtb.model.member.Member;

public interface MemberService {
    public Member getMemberByMemberId(String memberId);

    public void saveMember(Member member);
}
