package enums;

/**
 * Created by andrey on 3/26/15.
 */
public enum Levels {
    simple("simple", 3000, 4000),
    medium("medium", 2500, 3000),
    hard("hard", 1000, 4000);

    private final String level;
    private final int minSeconds;
    private final int maxSeconds;

    Levels(String level, int minTime, int maxTime) {
        this.level = level;
        this.minSeconds = minTime;
        this.maxSeconds = maxTime;
    }

    public String toString() {
        return this.level;
    }

    public int getMinSeconds() {
        return this.minSeconds;
    }

    public int getMaxSeconds() {
        return this.maxSeconds;
    }
}
