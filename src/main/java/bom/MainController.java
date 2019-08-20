package bom;

import bom.service.BigbagiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    BigbagiService bigbagiService;

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView m = new ModelAndView();
        m.setViewName("index");
        m.addObject("zgloszenia", bigbagiService.findAll());
        return m;
    }
    @GetMapping("/index")
    public ModelAndView getIndexView() {
        return getIndex();
    }

}
