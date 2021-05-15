package hello.servlet.basic;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // http 요청이오면 아래의 service 메소드를 실행시킨다.
    // request: 웹 브라우져에서 생성하여 전달
    // response: 서블릿에서 생성하여 웹 브라우져(client)에 전달
    /*
    HttpServletRequest란
    http요청 메세지를 자동으로 개발자대신에 파싱해준다.
    그 결과를 HttpServletRequest 객체에 담아서 제공해준다.

    HTTP 요청 메세지 구조
    - START LINE
    - Header
    - Body

    부가기능
    - 임시저장소 기능: request.setAttribute(name, value), request.getAttribute(name)
    - 세션 관리 기능

     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        String username = req.getParameter("username");
        System.out.println("username = " + username);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello "+username);
    }
}
