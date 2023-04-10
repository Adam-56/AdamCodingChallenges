package application;

public class InvalidGradeException extends Exception {
    public InvalidGradeException() {
        super();
    }

    public InvalidGradeException(String message) {
        super(message);
    }

    public InvalidGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGradeException(Throwable cause) {
        super(cause);
    }
}



