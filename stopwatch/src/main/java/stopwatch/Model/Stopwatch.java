package stopwatch.Model;

public class Stopwatch extends Thread {
    private int elapsedSeconds;
    private String stopwatchName;
    private boolean isPaused;

    public Stopwatch(String name) {
        this.isPaused = false;
        this.stopwatchName = name;
        this.elapsedSeconds = 0;
    }

    public void run() {
        while(true) {
            if (this.isInterrupted()) {
                break;
            }

            try {
                if (isPaused) {
                    this.sleep(1000);
                } else {
                    this.sleep(1000);
                    elapsedSeconds++;
                }

            } catch (InterruptedException e) {
                System.out.println(this.stopwatchName + " stopwatch has been interrupted..");
            }
        }
    }

    public String getStopwatchName() {
        return stopwatchName;
    }

    public void restartTimer() {
        this.elapsedSeconds = 0;
    }

    public int getElapsedSeconds() {
        return elapsedSeconds;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Name: " + stopwatchName + ", ThreadID: "
                + this.getId() + ", Seconds: " + elapsedSeconds);

        if (isPaused) {
            stringBuilder.append(", PAUSED");
        } else {
             stringBuilder.append(", ACTIVE");
        }

        return stringBuilder.toString();
    }
}
