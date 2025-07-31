package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

/**
 * 애플리케이션 실제 동작에 필요한 구현 객체를 생성한다.
 * 생성한 객체 인스턴스를 생성자를 통해서 주입(연결)해준다.
 *
 * 리펙토링 : 중복을 제거하고 역할에 따른 구현이 보이도록 수정 (memberRepository, discountPolicy 함수 추가)
 * 리팩토링 : 순수 자바 코드 -> 스프링으로 전환 (ApplicationContext -> @Configuration, @Bean 어노테이션 추가)
 * */
@Configuration
public class AppConfig {
  @Bean
  public MemberService memberService(){
    return new MemberServiceImpl(memberRepository());
  }
  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(
            memberRepository(),
            discountPolicy()
    );
  }
  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
  @Bean
  public DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
}
