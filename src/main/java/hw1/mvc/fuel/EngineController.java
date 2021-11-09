package hw1.mvc.fuel;

import hw1.aspect.FuelExceptionHandle;
import hw1.mvc.Diesel;
import hw1.mvc.EngineStorage;
import hw1.mvc.EngineType;
import hw1.mvc.Petrol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/mvc")
public class EngineController {

    @PostConstruct
    private void postConstruct() {
        EngineStorage.getEngines().add(new Petrol());
        EngineStorage.getEngines().add(new Diesel());
    }

    @FuelExceptionHandle
    @RequestMapping(method = RequestMethod.GET)
    public void fuelType() {


        if (EngineStorage.getEngines().getType() == EngineType.PETROL) new Petrol().powerUp();
        //else if (EngineType.DIESEL) new Diesel().powerUp();
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

    /*
    @PostMapping("add")
    public String addPost(@RequestParam(fuel) String fuel, Model model) {
        EngineStorage.getEngines().add(new Petrol());
        EngineStorage.getEngines().add(new Diesel());
        model.addAttribute("engines", EngineStorage.getEngines());
        return "show";
    } */
}
