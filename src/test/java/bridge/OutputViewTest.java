package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printMap() {
        OutputView outputView = new OutputView();
        List<String> currBridge = List.of("U", "D", "D");
        outputView.printMap(currBridge, false);
    }

    @Test
    void printResult() {
    }
}