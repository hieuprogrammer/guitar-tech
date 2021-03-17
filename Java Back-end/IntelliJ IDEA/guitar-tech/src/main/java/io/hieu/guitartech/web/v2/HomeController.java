package io.hieu.guitartech.web.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "Home Controller", path = { "" })
public class HomeController {
    @GetMapping(path = { "" })
    public String home() {
        return "home";
    }

    @GetMapping ("/swagger")
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }
}