package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
*
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("RequestParamServlet.service"); 메소드 잘 실행 되는지 확인완료
        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));
        //paramName : 키(Username) req.getParameter : 값(get,post 모든 방식의 값들을 다 가져올 수 있음)

        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
//        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        //잘 쓰는 방식은 아님. 보통은 단일 파라미터로.
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        resp.getWriter().write("ok");
    }
}