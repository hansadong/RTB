package com.toy.rtb.service.member;

import com.toy.rtb.model.Member;
import com.toy.rtb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
//    public Member getMemberByMemberId(String memberId) throws UsernameNotFoundException {
//        Optional<Member> memberOpt = memberRepository.findByMemberId(memberId);
//
//        if (!memberOpt.isPresent()) {
//            throw new UsernameNotFoundException("Member Not Found with memberId: " + memberId);
//        }
//
//        Member member = memberOpt.get();
//
//        return new org.springframework.security.core.userdetails.User(
//                member.getMemberId(),
//                member.getMemberPwd(),
//                member.getRoles().stream()
//                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                        .collect(Collectors.toList())
//        );
//    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }
}
