package stopwatch.View;

public enum ConsoleMessage {
    COMMAND_ERROR("ERROR: wrong command...\nAvailable commands:\n " +
            "- start timer_name(create new timer)\n" +
            "- stop timer_name(pause timer with given name)\n" +
            "(use stop timer_name again to reset)\n" +
            "- check (to see all created timers details)\n" +
            "- check timer_name (to see specified timer details)\n"),
    TIMERS_LIST_EMPTY("ERROR: You have no timers yet...\n"),
    EMPTY_TIMER_NAME_ERROR("ERROR: timer name cannot be empty...\n"),
    TIMER_STARTED("INFO: timer has been started...\n"),
    TIMER_NAME_ERROR("ERROR: wrong timer name...\n"),
    PAUSED_INFO("INFO: timer has been paused...\n"),
    UNPAUSED_INFO("INFO: timer is active again ...\n"),
    REQUEST_COMMAND("Command?"),
    RESTARTED_INFO("INFO: timer has been reset...\n"),
    EXIT_INFO("Thanks for using timer, have a good day, I go shut myself down now");

    private String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
