package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.GameContext.*;

public class Application {

    private static List<String> finalResult;

    public static void main(String[] args) {
        GameContext context = createBridgeGame();

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = context.inputView.readBridgeSize();
        finalResult = context.bridgeMaker.makeBridge(bridgeSize);

        GameResult result = playGame(context, bridgeSize, finalResult);

        context.outputView.printResult(result.getCurrBridge(), result.isSuccess(), result.getGameCount());
    }

    /**
     * 다리 건너기 게임의 전체 진행을 담당
     */
    private static GameResult playGame(GameContext context, int bridgeSize, List<String> finalResult) {
        List<String> currBridge = new ArrayList<>();
        int gameCount = 1;

        for(int currPosition = 0; currPosition < bridgeSize; currPosition++) {
            if (processMove(context, currBridge, currPosition)) continue;
            if (!retryGame(context, currBridge)) {
                return new GameResult(gameCount, false, currBridge);
            }
            currPosition = -1;
            gameCount++;
        }
        return new GameResult(gameCount, true, currBridge);
    }

    /**
     * 이동을 처리하는 함수
     */
    private static boolean processMove(GameContext context, List<String> currBridge, int currPosition) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = context.inputView.readMoving();
        currBridge.add(moving);
        boolean success = context.bridgeGame.move(finalResult, currPosition, moving);
        context.outputView.printMap(currBridge, success);
        return success;
    }

    /**
     * 게임 재시도를 처리하는 함수
     */
    private static boolean retryGame(GameContext context, List<String> currBridge) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = context.inputView.readGameCommand();
        return context.bridgeGame.retry(currBridge, gameCommand);
    }
}
