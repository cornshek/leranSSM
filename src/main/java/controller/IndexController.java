package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "Hello Spring MVC");
        return modelAndView;
    }

    @RequestMapping("/jump")
    public ModelAndView jump() {
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer i = (Integer) session.getAttribute("count");
        if (i == null) {
            i = 0;
        }
        i++;
        session.setAttribute("count", i);
        return new ModelAndView("check");
    }

    @RequestMapping("/clear")
    public ModelAndView clear(HttpSession session) {
        session.setAttribute("count", 0);
        return new ModelAndView(("redirect:check"));
    }
}
