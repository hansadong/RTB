package com.toy.rtb.service.member;

import com.toy.rtb.model.member.Member;

public interface MemberService {
    public void saveMember(Member member);

    public Member getMemberByMemberId(String memberId);

    public Member getMemberByNickName(String nickName);
}
