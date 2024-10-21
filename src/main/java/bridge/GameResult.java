package bridge;

import java.util.List;

public class GameResult {
    private final int gameCount;
    private final boolean success;
    private final List<String> currBridge;

    public GameResult(int gameCount, boolean success, List<String> currBridge) {
        this.gameCount = gameCount;
        this.success = success;
        this.currBridge = currBridge;
    }

    public int getGameCount() {
        return gameCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getCurrBridge() {
        return currBridge;
    }
}
