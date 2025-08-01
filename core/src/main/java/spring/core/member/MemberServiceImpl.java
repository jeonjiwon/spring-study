package spring.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("memberService2")
@Component
public class MemberServiceImpl implements MemberService {

//  private final MemberRepository memberRepository = new MemoryMemberRepository();

  private final MemberRepository memberRepository;  /// 추상화에만 의존하게 끔 처리된다.

  @Autowired //자동 의존관계 주입
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public void join(Member member) {
    memberRepository.save(member);
  }
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  // 싱글톤 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
