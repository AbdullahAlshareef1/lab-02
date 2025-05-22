package cpit305.fcit.kau.edu.sa;

public class OutOfRangeException extends Exception {
    private final int min;
    private final int max;

    public OutOfRangeException(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String getMessage() {
        return "Error: number must be between " + min + " and " + max;
    }
}
