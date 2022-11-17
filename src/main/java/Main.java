import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RacingManager manager = new RacingManager(new InputView(), new ResultView(),
                new ScannerUtils(new Scanner(System.in)));
        manager.playGame();
    }
}
