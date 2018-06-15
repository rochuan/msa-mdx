package com.mdx.common;

abstract  class SimpleResp {
    private int code;

    private String message;

    private String traceId;

    public SimpleResp() {

    }
    public SimpleResp(int code) {
        this.code = code;
    }

    public SimpleResp(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public SimpleResp(int code, String message) {
        this.code = code;
        this.message = message;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
