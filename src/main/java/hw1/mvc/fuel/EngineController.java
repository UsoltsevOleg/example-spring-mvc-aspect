package hw1.mvc.fuel;

import hw1.aspect.FuelExceptionHandle;
import hw1.mvc.Engine;
import hw1.mvc.EngineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EngineController {

    private final List<Engine> engineList;

    @Autowired
    public EngineController(List<Engine> engineList) {
        this.engineList = engineList;
    }

    @FuelExceptionHandle
    @GetMapping("/mvc/fuel/check")
    public String fuelType(@ModelAttribute EngineType type) {
        for (Engine engine : engineList) {
            if (engine.getType() == type) return engine.powerUp();
        }
        return null;
        //return engineList.stream().filter(x -> x.getType().equals(type)).for-each(x -> x.powerUp());
    }
}