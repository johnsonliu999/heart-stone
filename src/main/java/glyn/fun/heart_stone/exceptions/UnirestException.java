package glyn.fun.heart_stone.exceptions;

public class UnirestException extends RuntimeException {

    public UnirestException() {
    }

    public UnirestException(String message) {
        super(message);
    }

    public UnirestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnirestException(Throwable cause) {
        super(cause);
    }

    public UnirestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
