package stopwatch.Model;

public class Stopwatch extends Thread {
    private Integer stopWatchID;
    private Long startTime;
    private Long stopTime;
    private boolean isPaused;

    public Stopwatch() {
        this.isPaused = false;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public Long getTime() {
        return startTime - stopTime;
    }
}
