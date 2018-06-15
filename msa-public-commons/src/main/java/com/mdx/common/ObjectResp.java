package com.mdx.common;

public class ObjectResp<T> extends SimpleResp {
    private T response;
    public ObjectResp(int code) {
        super(code);
    }

    public ObjectResp() {

    }
    public ObjectResp(ErrorCode errorCode) {
        super(errorCode);
    }

    public ObjectResp(int code, String message) {
        super(code, message);
    }

    public ObjectResp(T response, ErrorCode errorCode){
        super(errorCode);
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public ObjectResp(T response){
        if(null != response){
            this.setCode(BaseErrorCode.SUCCESS.getCode());
            this.setMessage(BaseErrorCode.SUCCESS.getMessage());
        }
        this.response = response;
    }
}
