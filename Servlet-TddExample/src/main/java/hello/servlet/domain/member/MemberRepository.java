package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//class 명 command + shift + t를 누르면 테스트 케이스 생성 가능
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    //싱글톤 패턴
    private static final MemberRepository instance = new MemberRepository();
    //최초 1회 인스턴스 생성
    public static MemberRepository getInstance() {
        return instance;
    }
    //아무나 생성자를 사용할 수 없게 제한
    private MemberRepository(){
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
