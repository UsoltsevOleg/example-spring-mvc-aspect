package hw1.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Petrol implements Engine {

    @Override
    public String powerUp() {
        return "Данный двигатель использует бензин";
    }

    @Override
    public EngineType getType() {
        return  EngineType.PETROL;
    }
}
