package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Http Response Servlet의 역할
- HTTP 응답 메세지 생성
- HTTP 응답코드 지정
- 헤더 생성
- 바디 생성

개발자가 직접하지 않아도 servlet이 자동으로 생성해준다.
부가적인 기능으로는 "Content-type", 쿠기, redirect 등이 있다.

 */
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line] -> response 응답의 가장 첫 줄
        response.setStatus(HttpServletResponse.SC_OK);

        header(response);

        content(response);

        cookie(response);

        redirect(response);
    }

    private void header(HttpServletResponse response) throws IOException {
        // [response-headers]
        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 뮤효화
        response.setHeader("pragma", "no-cache");
        response.setHeader("my-header", "hello");

        response.getWriter().write("안녕하세요.");
    }

    // setHeader가 아닌 각 설정 메소드를 사용해도 됨
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        response.setStatus(HttpServletResponse.SC_FOUND); //302
        response.setHeader("Location", "/basic/hello-form.html");
        //response.sendRedirect("/basic/hello-form.html");
    }
}
