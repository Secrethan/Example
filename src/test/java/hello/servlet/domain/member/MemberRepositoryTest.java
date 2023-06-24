package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트를 진행할 때 순서 보장이 되지않기 때문에 다른 테스트 결과에 영향을 미칠 수 있음
    //따라서 각 테스트가 종료되고 다른 테스트에 영향을 끼치지 않게끔 초기화 작업은 반드시 해야한다.
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given 조건
        Member member = new Member("hello",27);

        //when 실행
        Member savedMember = memberRepository.save(member);

        //then 결과
        Member findMember = memberRepository.findById(savedMember.getId());
        //assertj , option + 왼쪽탭
        assertThat(findMember).isEqualTo(savedMember);

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("park", 22);
        Member member2 = new Member("Lee", 25);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        //result(list)에 2개의 값이 들어가 있기 때문에 사이즈 체크
        assertThat(result.size()).isEqualTo(2);
        //result(list)에 member1, 2가 들어가 있는지 체크
        assertThat(result).contains(member1,member2);

    }

    @Test
    void clearStore() {
    }
}