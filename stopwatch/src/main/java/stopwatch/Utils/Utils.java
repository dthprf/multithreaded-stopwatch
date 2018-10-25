package stopwatch.Utils;

import java.util.Scanner;

public class Utils {
    private static final String EMPTY_COMMAND_MSG = "Empty input, try again...";

    public static String getInput(String message) {
        String input = null;

        while (input == null) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (input == null) {
                System.out.println(EMPTY_COMMAND_MSG);
            }
        }

        return input;
    }

}
