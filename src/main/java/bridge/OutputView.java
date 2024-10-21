package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<String> currBridge, boolean success) {
        printBridge(currBridge, success, "U");
        printBridge(currBridge, success, "D");
        System.out.println();
    }

    /**
     * 주어진 방향(위 또는 아래)에 따른 다리 상태를 출력한다.
     */
    private void printBridge(List<String> currBridge, boolean success, String reverse) {
        System.out.print("[ ");
        for(int i = 0; i < currBridge.size(); i++) {
            boolean isFailureAtLast = !success && i == currBridge.size() - 1;
            printSymbol(currBridge.get(i), reverse, isFailureAtLast);
            if (i != currBridge.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 칸의 상태에 따라 "O", "X", 또는 공백을 출력하는 메서드
     */
    private void printSymbol(String currPosition, String reverse, boolean isFailureAtLast) {
        if (currPosition.equals(reverse) && isFailureAtLast) {
            System.out.print("X");
        } else if (currPosition.equals(reverse)){
            System.out.print("O");
        } else {
            System.out.print(" ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(List<String> currBridge, boolean success, int gameCount) {
        System.out.println("최종 게임 결과");
        printMap(currBridge, success);

        System.out.print("게임 성공 여부: ");
        if (success) System.out.println("성공");
        else System.out.println("실패");
        System.out.println("총 시도한 횟수: " + gameCount);
    }
}
