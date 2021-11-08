package hw1.mvc;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class EngineStorage {

    private static List<Engine> engines = new LinkedList<>();

    public static List<Engine> getEngines() {
        return engines;
    }
}
