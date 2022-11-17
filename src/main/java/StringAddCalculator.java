import java.util.Arrays;

public class StringAddCalculator {

    private static String defaultDelimeter = ":|,";

    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        String delimeter = defaultDelimeter;
        if(isHavingCustomDelimeter(input)) {
            delimeter = getCustomDelimeter(input);
            input = getInputStringWithoutCustomDelimeter(input);
        }

        return Arrays.stream(input.split(delimeter))
                .mapToInt(StringAddCalculator::getPositiveNoOrThrowException)
                .sum();
    }

    private static String getInputStringWithoutCustomDelimeter(String input) {
        return input.replaceAll(".*[\\n]", "");
    }

    private static int getPositiveNoOrThrowException(String str) {
        int parseInt = Integer.parseInt(str);
        if(parseInt < 0) {
            throw new RuntimeException();
        }
        return parseInt;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String getCustomDelimeter(String input) {
        return defaultDelimeter + "|"
                       + input.replaceAll("[\\n].*","")
                                 .replaceAll("//", "");
    }

    private static boolean isHavingCustomDelimeter(String input) {
        return input.startsWith("//");
    }

}
