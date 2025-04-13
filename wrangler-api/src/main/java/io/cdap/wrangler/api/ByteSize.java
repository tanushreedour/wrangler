public class ByteSize extends Token {
    private final long bytes;

    public ByteSize(String value) {
        super(Type.BYTE_SIZE, value);
        this.bytes = parseBytes(value);
    }

    private long parseBytes(String input) {
        input = input.toUpperCase();
        double number = Double.parseDouble(input.replaceAll("[A-Z]+", ""));
        if (input.endsWith("KB")) return (long)(number * 1024);
        if (input.endsWith("MB")) return (long)(number * 1024 * 1024);
        if (input.endsWith("GB")) return (long)(number * 1024 * 1024 * 1024);
        if (input.endsWith("TB")) return (long)(number * 1024L * 1024L * 1024L * 1024L);
        if (input.endsWith("PB")) return (long)(number * 1024L * 1024L * 1024L * 1024L * 1024L);
        return (long)number; // default bytes
    }

    public long getBytes() {
        return bytes;
    }
}

