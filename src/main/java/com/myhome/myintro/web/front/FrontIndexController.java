package com.myhome.myintro.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontIndexController {

    @GetMapping({"", "/"})
    public String index() {
        return "front/index";
    }
}
