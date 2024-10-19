package bridge;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.validation.Validator;

import static bridge.BridgeValidator.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true) {
            try {
                String bridgeSize = Console.readLine();
                int size = Integer.parseInt(bridgeSize);
                validateBridgeSize(size);
                return size;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 다리 길이는 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String moving = Console.readLine();
                validateMoving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String gameCommand = Console.readLine();
                validateGameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
