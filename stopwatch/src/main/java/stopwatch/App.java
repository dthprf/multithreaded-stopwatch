package stopwatch;

import stopwatch.Controller.StopwatchController;
import stopwatch.View.StopWatchView;

public class App
{
    public static void main( String[] args ) {
        StopwatchController controller = new StopwatchController(new StopWatchView());
        controller.runApp();
    }
}
