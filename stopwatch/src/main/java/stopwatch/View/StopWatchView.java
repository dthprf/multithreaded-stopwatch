package stopwatch.View;

import stopwatch.Model.Stopwatch;

public class StopWatchView {

    public void displayInfo(Stopwatch stopwatch) {
        System.out.println(stopwatch);
    }

    public void displayMessage(ConsoleMessage consoleMessage) {
        System.out.println(consoleMessage.message());
    }
}
