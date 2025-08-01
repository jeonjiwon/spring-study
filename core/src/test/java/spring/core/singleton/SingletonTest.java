package spring.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AppConfig;
import spring.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 호출할떄마다 새로 객체가 생성되어, 다른 인스턴스 값을 가지고 있다.
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // private으로 생성자를 막아두어 에러 발생
//        SingletonService singletonServiceError = new SingletonService();

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.login();

        /* [싱글톤 패턴 문제점]
        - 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
        - 의존관계상 클라이언트가 구체 클래스에 의존한다.  DIP를 위반한다.
        - 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
        - 테스트하기 어렵다.
        - 내부 속성을 변경하거나 초기화 하기 어렵다.
        - private 생성자로 자식 클래스를 만들기 어렵다.
        - 결론적으로 유연성이 떨어진다.
        - 안티패턴으로 불리기도 한다.
        */
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService1).isSameAs(memberService2);
    }

}
