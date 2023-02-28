package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 스프링이 자동으로 스프링 빈으로 등록한다.(@Controller 안에 @Component가 있어서 Component 스캔 대상이 됨)
// + 추가로 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다.
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    //요청 정보를 매핑한다. 해당 URL이 호출되면 이 메서드가 호출됨. 메서드 이름은 상관없음.
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
