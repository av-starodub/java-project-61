package hexlet.code.exception;

public class WrongChoiceException extends RuntimeException {
    public WrongChoiceException(String message) {
        super(message);
    }
}
