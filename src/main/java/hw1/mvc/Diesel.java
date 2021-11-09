package hw1.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Diesel implements Engine {

    @Override
    public String powerUp() {
        return "Данный двигатель использует дизельное топливо";
    }

    @Override
    public EngineType getType() {
        return  EngineType.DIESEL;
    }
}
