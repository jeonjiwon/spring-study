package spring.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.core.member.Grade;
import spring.core.member.Member;

@Component
//@Qualifier("FixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000; //1000원 할인

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    else {
      return 0;
    }
  }

}
