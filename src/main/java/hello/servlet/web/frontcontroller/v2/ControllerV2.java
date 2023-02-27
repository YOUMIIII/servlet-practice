package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    //void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    //ControllerV1에서는 위 코드를 썼다면 이번엔 같긴 하지만 MyView로 반환하는 메소드로 작성.(모든 컨트롤러가 뷰(JSP)를 반환하고 있기때문)
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
