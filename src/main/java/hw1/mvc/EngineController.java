package hw1.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/mvc")
public class EngineController {

    @PostConstruct
    private void postConstruct() {
        EngineStorage.getEngines().add(new Petrol("бензин"));
        EngineStorage.getEngines().add(new Diesel("дизельное топливо"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String example() {
        return "example";
    }

    @GetMapping("show")
    public String show(Model model) {
        model.addAttribute("engines", EngineStorage.getEngines());
        return "show";
    }

    @GetMapping("add")
    public String add() {
        return "add";
    }

    @PostMapping("add")
    public String addPost(@RequestParam("fuel") String fuel, Model model) {
        EngineStorage.getEngines().add(new Petrol(fuel));
        EngineStorage.getEngines().add(new Diesel(fuel));
        model.addAttribute("engines", EngineStorage.getEngines());
        return "show";
    }
}
