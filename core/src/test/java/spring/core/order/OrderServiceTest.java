package spring.core.order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.AppConfig;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;

class OrderServiceTest {
  MemberService memberService;
  OrderService orderService;


  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder() {
    long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);
    Order order = orderService.createOrder(memberId, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

  @Test
  @DisplayName("autowird - 필드주입 문제점 ")
  void fieldInjectionTest() {
//    OrderServiceImpl orderService = new OrderServiceImpl();
////    orderService.setMemberRepository(new MemoryMemberRepository());
////    orderService.setDiscountPolicy(new FixDiscountPolicy());
//    orderService.createOrder(1L, "itemA", 10000); //java.lang.NullPointerException 발생
  }


}