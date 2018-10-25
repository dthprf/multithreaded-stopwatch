package stopwatch.Model;

public class UserCommand {
    private static final int COMMAND_INDEX = 0;
    private static final int TIMER_NAME_INDEX = 1;

    private String command;
    private String stopwatchName;

    public UserCommand(String[] userCommand) {
        this.command = userCommand[COMMAND_INDEX];

        if (userCommand.length == 2) {
            this.stopwatchName = userCommand[TIMER_NAME_INDEX];
        }
    }

    public String getCommand() {
        return command;
    }

    public String getStopwatchName() {
        return stopwatchName;
    }
}
