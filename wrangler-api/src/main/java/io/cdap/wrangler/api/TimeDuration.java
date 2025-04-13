public class TimeDuration extends Token {
    private final long milliseconds;

    public TimeDuration(String value) {
        super(Type.TIME_DURATION, value);
        this.milliseconds = parseMillis(value);
    }

    private long parseMillis(String input) {
        input = input.toLowerCase();
        double number = Double.parseDouble(input.replaceAll("[a-z]+", ""));
        if (input.endsWith("ms")) return (long) number;
        if (input.endsWith("s")) return (long)(number * 1000);
        if (input.endsWith("m")) return (long)(number * 60000);
        if (input.endsWith("h")) return (long)(number * 3600000);
        return (long) number;
    }

    public long getMilliseconds() {
        return milliseconds;
    }
}
