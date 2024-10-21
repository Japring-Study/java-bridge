package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public boolean move(List<String> finalResult, int currPosition, String moving) {
        return finalResult.get(currPosition).equals(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public boolean retry(List<String> currBridge, String gameCommand) {
        if (gameCommand.equals("Q")) {
            return false;
        }
        currBridge.clear();
        return true;
    }

}
