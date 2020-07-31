package io.hieu.guitartech.controller.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "Home Controller", path = { "/api/v2", "/api/v2/home", "/api/v2/home.html", "/api/v2/index", "/api/v2/index.html" })
public class HomeController {
    @GetMapping(path = { "", "/" })
    public String home() {
        return "home";
    }

    @RequestMapping ("/swagger")
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }
}