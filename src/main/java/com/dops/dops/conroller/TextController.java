package com.dops.dops.conroller;

import com.dops.dops.dao.City;
import com.dops.dops.dao.CityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TextController {
    final   CityRepository repository;

    public TextController(CityRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        List<City> all = repository.findAll();
        if (all.size() == 0){
            repository.save(new City("Магадан"));
            repository.save(new City("Сочи"));
            repository.save(new City("Минск"));
        }
        all.forEach(System.out::println);
        return "Hello, World";
    }
}
