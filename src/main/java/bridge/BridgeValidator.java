package bridge;

public class BridgeValidator {

    /**
     * 다리 길이가 3 이상 20 이하인지 검증
     */
    public static void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 이동할 칸이 U 또는 D인지 검증
     */
    public static void validateMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U(위), D(아래) 중 하나여야 합니다.");
        }
    }

    /**
     * 게임 명령어가 R 또는 Q인지 검증
     */
    public static void validateGameCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임 명령어는 R(재시작), Q(종료) 중 하나여야 합니다.");
        }
    }
}
