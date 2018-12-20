package com.cennavi.plan.model;

public class ResultObj<T> {
    private boolean isSuccess;
    private String retCode;
    private String msg;
    private Exception exception;
    private T result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "ResultObj{" +
                ", isSuccess=" + isSuccess +
                ", retCode='" + retCode + '\'' +
                ", msg='" + msg + '\'' +
                ", exception=" + exception +
                ", result=" + result +
                '}';
    }
}
