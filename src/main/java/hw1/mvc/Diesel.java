package hw1.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diesel implements Engine {

    private String fuel;

    @Override
    public void powerUp() {
        System.out.println("Данный двигатель использует " + fuel);
    }
}
