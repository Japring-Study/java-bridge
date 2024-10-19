package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> currBridge, boolean success) {
        printBridge(currBridge, success, "U");
        printBridge(currBridge, success, "D");
        System.out.println();
    }

    private void printBridge(List<String> currBridge, boolean success, String reverse) {
        System.out.print("[ ");
        for(int i = 0; i < currBridge.size(); i++) {
            printOorX(currBridge, success, reverse, i);
            if (i != currBridge.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    private void printOorX(List<String> currBridge, boolean success, String reverse, int index) {
        if (currBridge.get(index).equals(reverse) && index == currBridge.size() - 1 && !success) {
            System.out.print("X");
        } else if (currBridge.get(index).equals(reverse)){
            System.out.print("O");
        } else {
            System.out.print(" ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
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
