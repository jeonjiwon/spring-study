package spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.core.discount.DiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

@Configuration
@ComponentScan(
//        basePackages = "spring.core.member",
//        // 컴포넌트 스캔 시작 패키지 위치를 지정
//        basePackageClasses = AutoAppConfig.class,
        // default(basePackages 미 등록시) 위치 : 현재 위치의 패키지 하위 (여기서는 spring.core)

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // AppConfig 제외하기 위함 (기존예제 코드를 ...유지하기 위함, 원래는 잘 안씀 )
) 
public class AutoAppConfig {

    // 수동 빈 (자동빈 보다 우선권을 가진다)
    // Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacing ~~
    // 애매할 상황을 만들지 마라 ! 동일 자바빈 만들지 마!
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

//    @Autowired
//    MemberRepository memberRepository;
//
//    @Autowired
//    DiscountPolicy discountPolicy;
//
//    @Bean
//    OrderService orderService() {
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }


}
