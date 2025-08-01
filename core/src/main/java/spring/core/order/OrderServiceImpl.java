package spring.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService{
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;
  ////  @Autowired  //생성자가 1개면 생략 가능함
//  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//
//    System.out.println("memberRepository = " + memberRepository);
//    System.out.println("discountPolicy = " + discountPolicy);
//  }

  // 필드주입 (사용하지말것)
//  @Autowired private MemberRepository memberRepository;
//  @Autowired private DiscountPolicy discountPolicy;

//  private MemberRepository memberRepository;
//  private DiscountPolicy discountPolicy;
//
//  public void setMemberRepository(MemberRepository memberRepository) {
//    this.memberRepository = memberRepository;
//  }
//
//  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//    this.discountPolicy = discountPolicy;
//  }

//  public OrderServiceImpl() {
//
//  }

//  @Autowired(required = false)
//  public void setMemberRepository(MemberRepository memberRepository) {
//    System.out.println("setter memberRepository = " + memberRepository);
//    this.memberRepository = memberRepository;
//  }
//
//  @Autowired(required = false)
//  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//    System.out.println("setter discountPolicy = " + discountPolicy);
//    this.discountPolicy = discountPolicy;
//  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  //싱글톤 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

}
