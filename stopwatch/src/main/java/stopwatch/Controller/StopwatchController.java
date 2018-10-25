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

    public void runApp() {
        boolean isRunning = true;

        while (isRunning) {
            UserCommand command = parseCommandFromInput(Utils.getInput(
                    ConsoleMessage.REQUEST_COMMAND.message()));

            switch (command.getCommand()) {
                case START_COMMAND:
                    handleStartCommand(command.getStopwatchName());
                    break;

                case STOP_COMMAND:
                    handleStopCommand(command.getStopwatchName());
                    break;

                case CHECK_COMMAND:
                    handleCheckCommand(command.getStopwatchName());
                    break;

                case EXIT_COMMAND:
                    handleExitCommand();
                    isRunning = false;
                    break;

                default:
                    view.displayMessage(ConsoleMessage.COMMAND_ERROR);
            }
        }
    }




}
