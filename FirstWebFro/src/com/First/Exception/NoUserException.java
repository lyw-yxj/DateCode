package com.First.Exception;
//运行时异常处理类
public class NoUserException extends RuntimeException{


    public NoUserException() {
    }

    public NoUserException(String message) {
        super(message);
    }

    public NoUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
