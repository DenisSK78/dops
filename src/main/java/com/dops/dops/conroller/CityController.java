package com.dops.dops.conroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CityController {

    Logger logger = LoggerFactory.getLogger(CityController.class);

    @Controller
    public class HomeController {

        @RequestMapping("/")
        public @ResponseBody
        String greeting() {
            return "Hello, World";
        }

    }
}
