package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    // JSON object에 매핑하기 -> jackson
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);
        /*
        messageBody = {
            "username": "lee",
            "age": 30
        }
         */

        // JSON 형태로 받은 데이터를 hellodata 객체로 파싱하기
        // jackson, Gson 등의 라이브러리를 사용하여 간단하게 파싱가능
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println(helloData.getAge());

        response.getWriter().write("ok");
    }
}
