package com.toy.rtb.service.member;

import com.toy.rtb.model.member.Member;
import com.toy.rtb.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public User loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Optional<Member> memberOpt = memberRepository.findByMemberId(memberId);

        if (!memberOpt.isPresent()) {
            throw new UsernameNotFoundException("Member Not Found with memberId: " + memberId);
        }

        Member member = memberOpt.get();

        return new org.springframework.security.core.userdetails.User(
                member.getMemberId(),
                member.getMemberPwd(),
                Collections.emptyList()
        );
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public Member getMemberByMemberId(String memberId) {
        return memberRepository.getMemberByMemberId(memberId);
    }

    public Member getMemberByNickName(String nickName) {
        return memberRepository.getMemberByNickName(nickName);
    }
}
