package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller
 * - 스프링이 자동으로 빈 등록해준다.
 * - 내부에 @Component가 있기에 컴포넌트 스캔 대상이 된다.
 * - 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다. -> RequestMappingHandler로 인식하게 한다.
 *
 * @RequestMapping
 * - 요청 정보를 매핑한다.
 * - 애노테이션 기반으로 동작하므로 메소드의 이름은 임의로 작성해도 된다.
 * - RequestMappingHandlerMapping => 핸들러 매핑
 * - RequestMappingHandlerAdapter => 핸들러 어댑터
 *
 * RequestMappingHandlerMapping은 스프링 빈중에 @RequestMapping 또는 @Controller가 클래스 레벨에 있는 경우
 * 매핑 정보로 인식한다.
 *
 */
@Controller
//@Component
//@RequestMapping
public class SpringMemberFormController {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
