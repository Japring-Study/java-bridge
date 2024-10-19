package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeGameTest {

    @Test
    void move() {
    }

    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> currBridge = new ArrayList<>(List.of("U", "D"));
        int currPosition = 1;
        bridgeGame.retry(currBridge);
        System.out.println(currBridge);
        System.out.println(currPosition);
    }
}