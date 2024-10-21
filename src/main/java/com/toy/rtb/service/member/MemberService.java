package com.toy.rtb.service.member;

import com.toy.rtb.model.Member;

public interface MemberService {
    public Member getMemberByMemberId(String memberId);

    public void saveMember(Member member);
}
