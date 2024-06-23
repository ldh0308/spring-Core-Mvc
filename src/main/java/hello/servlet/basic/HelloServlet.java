package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
// name, urlPatterns 중복 X
// name: 서블릿 이름, urlPatterns: URL 매핑
public class HelloServlet extends HttpServlet {
    @Override
    // Http 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username); // http://localhost:8080/hello?username=Lee

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username); // hello Lee 출력

    }
}
