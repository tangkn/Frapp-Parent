package com.tan.frap.exception;

public interface FrapExceptions {

    FrapException USER_NOT_FOUND_EXCEPTION = new FrapException(600, "User not found");
    FrapException INVALID_ARGUMENT = new FrapException(100, "Invalid argument");
    FrapException DATABASE_ERROR = new FrapException(200, "Database error");
    FrapException AUTHENTICATION_ERROR = new FrapException(300, "Authentication error");

}
