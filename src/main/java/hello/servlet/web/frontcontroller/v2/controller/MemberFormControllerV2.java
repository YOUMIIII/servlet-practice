package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //V1에서 사용한 코드. 이제는 new로 view에만 넘겨주면 된다
        /*String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath); //controller에서 뷰로 이동할때 사용
        requestDispatcher.forward(request, response);
        */

        MyView myView = new MyView("/WEB-INF/views/new-form.jsp");
        return myView;
        //위랑 같은뜻(인라인) return new MyView("/WEB-INF/views/new-form.jsp");


    }
}
