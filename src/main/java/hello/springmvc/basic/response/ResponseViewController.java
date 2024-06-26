package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class
ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        Model data = model.addAttribute("data", "hello!");
        return "response/hello";
    }
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        Model data = model.addAttribute("data", "hello!");
    } // void 로 하면 요청 url 과 같은 이름의 뷰를 찾아서 렌더링 한다.

}
