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

    private void displayAllTimersInfo() {
        for (Stopwatch stopwatch : stopwatchesList) {
            view.displayInfo(stopwatch);
        }
    }

    private Stopwatch getStopwatchByName(String name) {
        for (Stopwatch stopwatch : stopwatchesList) {
            if (stopwatch.getStopwatchName().equals(name)) {
                return stopwatch;
            }
        }
        return null;
    }

    private UserCommand parseCommandFromInput(String input) {
        String[] splitedInput = input.toLowerCase().trim().split(" ", 2);
        return new UserCommand(splitedInput);
    }

    private void handleStartCommand(String stopWatchName) {
        Stopwatch stopwatch = getStopwatchByName(stopWatchName);
        if (stopWatchName == null) {
            view.displayMessage(ConsoleMessage.EMPTY_TIMER_NAME_ERROR);

        } else if (stopwatch == null) {
            Stopwatch newTimer = new Stopwatch(stopWatchName);
            newTimer.start();
            stopwatchesList.add(newTimer);
            view.displayMessage(ConsoleMessage.TIMER_STARTED);

        } else if (stopwatch.isPaused()) {
            stopwatch.setPaused(false);
            view.displayMessage(ConsoleMessage.UNPAUSED_INFO);

        } else {
            view.displayMessage(ConsoleMessage.TIMER_NAME_ERROR);
        }
    }

    private void handleStopCommand(String stopWatchName) {
        Stopwatch stopwatch = getStopwatchByName(stopWatchName);

        if (stopwatch == null) {
            view.displayMessage(ConsoleMessage.TIMER_NAME_ERROR);

        } else if (!stopwatch.isPaused()) {
            stopwatch.setPaused(true);
            view.displayMessage(ConsoleMessage.PAUSED_INFO);

        } else if (stopwatch.isPaused()) {
            stopwatch.restartTimer();
            view.displayMessage(ConsoleMessage.RESTARTED_INFO);
        }
    }


}
