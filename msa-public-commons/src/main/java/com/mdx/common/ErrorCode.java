package com.mdx.common;

public interface ErrorCode {

    /**
     * 错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 错误消息
     *
     * @return 错误消息
     */
    String getMessage();

    void setMessage(String message);
}
