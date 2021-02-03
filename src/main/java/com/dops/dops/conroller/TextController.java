package com.dops.dops.conroller;

import com.dops.dops.dao.City;
import com.dops.dops.dao.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TextController {

    Logger logger = LoggerFactory.getLogger(TextController.class);
    final   CityRepository repository;

    public TextController(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public @ResponseBody String greeting() {
        List<City> all = repository.findAll();
        if (all.size() == 0){
            repository.save(new City("Магадан"));
            repository.save(new City("Сочи"));
            repository.save(new City("Минск"));
            logger.info("Add city for empty repository.");
        }
        all.forEach(e -> logger.info(e.toString()));
        return "<h3>Main page!</h3>";
    }

    @GetMapping("/city")
    public @ResponseBody String listCity(@RequestParam(value = "name", required = false) String name) {
        if(name != null && !name.isEmpty()) repository.save(new City(name));
        List<City> all = repository.findAll();
        logger.info("Get all city.");
        return all.stream().map(e -> "<h3>" + e.toString() + "</h3>")
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/city/{id}")
    public @ResponseBody String getCity(@PathVariable Long id) {
        Optional<City> one = repository.findById(id);
        logger.info("Get by id");
        return one.map(city -> "<h3>" + city.toString() + "</h3>")
                .orElse("<h3>Не найдено!!</h3>");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteCity(@PathVariable Long id) {
        repository.deleteById(id);
        logger.info("Delete by id");
        return new RedirectView("/city");
    }
}
