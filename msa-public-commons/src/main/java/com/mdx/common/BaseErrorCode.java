package com.mdx.common;

import java.util.HashMap;

public enum BaseErrorCode implements ErrorCode {

    SUCCESS             (200, "成功"),;

    private static HashMap<Integer, BaseErrorCode> codeHash;

    static {
        codeHash = new HashMap<Integer, BaseErrorCode>();
        for (BaseErrorCode item : BaseErrorCode.values()) {
            codeHash.put(item.getCode(), item);
        }
    }

    public static BaseErrorCode getRespCodeByCode(int code) {
        return codeHash.get(code);
    }

    public static final int SUCCESS_CODE = 200;
    private int code;
    private String message;

    private BaseErrorCode(int code, String message) {
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

    public void setMessage(String msg) {
        this.message = msg;
    }

}
