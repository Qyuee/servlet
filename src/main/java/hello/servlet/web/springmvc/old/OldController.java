package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> 1. @Component를 통해서 해당 컨트롤러(핸들러)를 빈에 등록한다.</p>
 * <p> 2. 빈에 등록된 경로로 요청이 유입되면 DispatcherServlet(Front Controller)가 `핸들러매핑`을 통해 OldController를 반환한다.</p>
 * <h3> HanderMapping 우선순위 </h3>
 * <ul>
 *  <li> 1) RequestMappingHandlerMapping - 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용한다.</li>
 *  <li> 2) BeanNameUrlHandlerMapping - 스프링 빈의 이름으로 핸들러를 찾는다.</li>
 * </ul>
 *
 * <p> 3. OldController(handler)를 지원해줄 수 있는 어댑터를 찾아야한다.</p>
 * <p> - 어댑터의 supports()를 호출하여 지원이 가능한지 확인한다.</p>
 * <p> - SimpleControllerHandlerAdapter가 지원이 가능한 것을 확인한다.</p>
 *
 * <h3> Handler Adapter 우선순위</h3>
 *  <ul>
 *      <li> 1) RequestMappingHandlerAdapter - 애노테이션 기반의 컨트롤러인 @ReuqestMapping에서 사용</li>
 *      <li> 2) HttpRequestHandlerAdapter - HttpRequestHandler 처리 </li>
 *      <li> 3) SimpleControllerHandlerAdapter - Controller 인터페이스를 기반으로 구현된 handler 처리</li>
 *  </ul>
 *
 * <h2>OldController의 HandlerMapping, HandlerAdapter</h2>
 * <ul>
 *     <li>HandlerMapping - BeanNameUrlHandlerMapping</li>
 *     <li>HandlerAdapter - SimpleControllerHandlerAdapter</li>
 * </ul>
 *
 * @see org.springframework.web.servlet.DispatcherServlet
 * @see Controller
 * @see org.springframework.web.servlet.mvc.LastModified
 * @see org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter
 *
 */
// spring bean의 이름을 등록해준다.
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");    // new ModelAndView("/WEB-INF/views/new-form.jsp");
    }
}
