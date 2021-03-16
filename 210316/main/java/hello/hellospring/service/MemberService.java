package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();

        //메소드로 하나로 뽑아주는것이 좋음. 보기에 좋다.
        // MacBook에서는 단축기 Ctrl T 이던데, 윈도우는 무엇인지 한 번 찾아볼것
        // 메소드 묶기 ctrl + alt + shift + T

//        validateDuplicateMember(member); //위에 메소드를 validateDuplicateMember로 만들어줬음.
//        memberRepository.save(member);
//        return  member.getId();

//        memberRepository.save(member);
//        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById((memberId));
    }
}

