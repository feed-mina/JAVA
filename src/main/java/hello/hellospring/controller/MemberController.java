package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

     // DI에는 필드 주입 , setter 주입, 생성자 주입 3가지 방법이 있다.
     // 생성자를 통해 주입 -> 애플리케이션 조립 : 이후 setter처럼 작동 , setter injection은 아무 개발자나 가능할 수 있다.
    // 조립 시점에 주입하면 이후 변경할 일이 없기 때문에 Controller는 생성자 조립을 권장함 정형화 되지 않거나 상황에 따라 구현 클래스를 변경해ㅑㅇ 하면 설정을 통해 스프링 빈을 설정한다.
    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
        // memberController 가 memberservice를 통해 관리하고 데이터를 조회할 수 있어야 한다.
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }


    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        // System.out.println("member: "+member.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
