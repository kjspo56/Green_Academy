package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

    //Optional은 java 8부터 생겨난 기능으로 Null을 처리할때 사용한다.
}
