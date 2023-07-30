package frapp.parent.exception;

public class FrapException extends Exception{


    public final int errorCode;
    public final String errorMessage;

    public FrapException(int errorCode, String errorMessage) {
        super("Error " + errorCode + ": " + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public FrapException(int errorCode, String errorMessage, Throwable cause) {
        super("Error " + errorCode + ": " + errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
