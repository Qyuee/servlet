package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    어댑터 패턴을 활용하여 호환이 불가능한 클래스를 연관 관계로 연결해서 사용가능
 */
public interface MyHandlerAdapter {
    // handler는 컨트롤러를 의미한다.
    // 어댑터가 해당 컨트롤러를 처리 할 수 있는지 판단
    boolean supports(Object handler);

    // 어댑터가 대신 실제 컨트롤러를 호출한다.
    // 실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 직접 ModelView를 생성해서 반환한다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
