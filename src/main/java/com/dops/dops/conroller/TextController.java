package com.dops.dops.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello, World";
    }
}
