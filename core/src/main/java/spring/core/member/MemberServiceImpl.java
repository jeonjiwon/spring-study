package spring.core.member;

public class MemberServiceImpl implements MemberService {

//  private final MemberRepository memberRepository = new MemoryMemberRepository();

  private final MemberRepository memberRepository;  /// 추상화에만 의존하게 끔 처리된다.

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public void join(Member member) {
    memberRepository.save(member);
  }
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
