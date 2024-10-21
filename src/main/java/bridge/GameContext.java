package bridge;

/**
 * 게임의 다양한 컴포넌트를 하나의 컨텍스트로 묶어서 사용하기 쉽게 관리하는 클래스
 */
public class GameContext {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public GameContext (InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    /**
     * 게임의 모든 컴포넌트를 초기화하고 GameContext 객체를 생성하는 팩토리 메서드
     */
    public static GameContext createBridgeGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame();

        return new GameContext(inputView, outputView, bridgeMaker, bridgeGame);
    }
}
