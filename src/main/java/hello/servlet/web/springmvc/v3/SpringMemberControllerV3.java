package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    /**
     * ModelAndView를 반환해도되지만, String으로 view의 이름을 반환해도 인식한다.
     */
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    // 같음: @GetMapping(value = "/new-form")
    // @GetMapping의 내부를 보면 @RequestMapping이 있다.
    public String newForm() {
        return "new-form";
    }

    /**
     * HttpServletRequest, HttpServletResponse을 모두 받을 수 있다.
     * 하지만 @RequestParam을 통해서 바로 데이터를 사용 할 수도 있다.
     * === request.getParameter("username")
     *
     * 그리고 model에 담아서 뷰의 논리 이름을 바로 리턴.
     * ==> Model을 파라미터로 받는건 스프링 MVC의 편의기능이다.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    // 같음: @PostMapping(value = "/save")
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age,
                             Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
