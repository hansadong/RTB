package com.toy.rtb.service.member;

import com.toy.rtb.model.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
//    public Member getMemberByMemberId(String memberId);

    public void saveMember(Member member);
}
