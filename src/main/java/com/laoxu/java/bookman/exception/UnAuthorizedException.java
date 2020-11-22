package com.laoxu.java.bookman.exception;

/**
 * @Description: 未授权异常
 * @Author laoxu
 * @Date 2019/7/3 21:51
 **/
public class UnAuthorizedException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMessage;

    public UnAuthorizedException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
