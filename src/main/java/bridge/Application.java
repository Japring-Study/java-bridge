package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame();

        System.out.println("다리 건너기 게임을 시작합니다.");

        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        List<String> finalResult = bridgeMaker.makeBridge(bridgeSize);

        int gameCount = 1;
        boolean success = false;
        List<String> currBridge = new ArrayList<>();
        for(int currPosition = 0; currPosition < bridgeSize; currPosition++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = inputView.readMoving();
            currBridge.add(moving);
            success = bridgeGame.move(finalResult, currPosition, moving);
            outputView.printMap(currBridge, success);

            if (!success) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("Q")) break;
                currPosition = bridgeGame.retry(currBridge);
                gameCount++;
            }
        }

        outputView.printResult(currBridge, success, gameCount);
    }
}
