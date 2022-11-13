package hello.hellospring;


import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    // @Autowired를 통한 DI는 helloController , MemberService 등과 같이 스프링이 관리하는 객체에서만 동작한다. 스프링 빈으로 등로가힞 않고 내가 직접 생성한 객체에서는 동작하지 않는다.

}
