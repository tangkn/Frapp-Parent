package frapp.parent.exception;

public interface FrapExceptions {


    FrapException INVALID_ARGUMENT = new FrapException(100, "Invalid argument");
    FrapException USER_NOT_FOUND_EXCEPTION = new FrapException(101,"User not found");
    FrapException DATABASE_ERROR = new FrapException(102, "Database error");
    FrapException AUTHENTICATION_ERROR = new FrapException(103, "Authentication error");
    FrapException WRONG_USER_PASSWORD = new FrapException(104, "Wrong password!");;
}
