package stopwatch.Controller;

import stopwatch.Model.Stopwatch;
import stopwatch.Model.UserCommand;
import stopwatch.Utils.Utils;
import stopwatch.View.ConsoleMessage;
import stopwatch.View.StopWatchView;

import java.util.ArrayList;
import java.util.List;

public class StopwatchController {
    private final static String START_COMMAND = "start";
    private final static String STOP_COMMAND = "stop";
    private final static String CHECK_COMMAND = "check";
    private final static String EXIT_COMMAND = "exit";

    private StopWatchView view;
    private List<Stopwatch> stopwatchesList = new ArrayList<>();

    public StopwatchController(StopWatchView view) {
        this.view = view;
    }


}
