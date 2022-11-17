import java.util.Scanner;

public class ScannerUtils {
    private final Scanner scanner;
    public ScannerUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void close() {
        scanner.close();
    }

    public String[] getCarsName() {
        String input = scanner.nextLine();
        return input.split(",");
    }

    public int getRaceAttempt() {
        return scanner.nextInt();
    }
}
