package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members") // RequestMapping에서 중복되는 부분만 적어주면 아래 메소드엔 생략가능
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form") // 위 코드에서 @GetMapping으로 변경도 가능함(@GetMapping안에 @RequestMapping이 있음)
    public String newForm(){
        return "new-form";
        //애노테이션 기반의 컨트롤러는 v2처럼 ModelAndView로 반환해도 되고 문자를 반환해도 바로 뷰 이름이라고 알아서 생각해서 프로세스가 진행됨
    }

    @RequestMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age,
                       Model model){
        //@RequestParam == request.getParameter("username");
        //따로 코드에 적을 필요 없이 @RequestParam으로 파라미터로 바로 받을 수 있다.
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
