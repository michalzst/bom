package bom;

import bom.service.BigbagiService;
import bom.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    BigbagiService bigbagiService;

    @Autowired
    RoleService roleService;

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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addZgloszenie() {
        roleService.createRolesFromEnum();
        bigbagiService.createNewZgloszenie("Zabrać worki 4x", "Kowalski Jan", "Wyszyńskiego 16", "555-741-001", "3315, 3365, 1147, 2248", "123/08/2019");
        bigbagiService.createNewZgloszenie("Zabrać worki 1x", "Kowalski Jerzy", "Szczecińska 16", "888-524-785", "4171", "faktura nr 293/S22/2019");
        bigbagiService.createNewZgloszenie("Zabrać worki 2x", "Nowak Jan", "Wieniawskiego 22", "475-412-963", "7418, 7757", "346/08/2019");
        bigbagiService.createNewZgloszenie("Zabrać worki 3x", "Nowak Andrzej", "Witoszyskiego 6", "412-557-123", "4211, 2300, 7784", "215/07/2019");
        bigbagiService.createNewZgloszenie("Zabrać worki 1x", "Uściński Stanisław", "Portowa 1", "710-785-104", "2248", "789/07/2019");
        bigbagiService.createNewZgloszenie("Zabrać worki 6x", "Kowalski Piotr", "Klasztorna 1", "852-417-107", "2345, 1234, 5544, 1122, 8956, 7536", "faktura nr 710/S22/2019");
    }

}
