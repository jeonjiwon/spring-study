package spring.core;

import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

/**
 * 애플리케이션 실제 동작에 필요한 구현 객체를 생성한다.
 * 생성한 객체 인스턴스를 생성자를 통해서 주입(연결)해준다.
 * */
public class AppConfig {
  public MemberService memberService(){
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }
}
