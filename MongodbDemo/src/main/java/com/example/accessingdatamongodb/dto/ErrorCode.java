package com.example.accessingdatamongodb.dto;

import org.jetbrains.annotations.Nullable;

/**
 * @author hu
 */
public enum ErrorCode {

    NO_LOGIN("1001", "未登录"),
    NO_PERMISSION("1002", "无访问权限"),
    USER_NOT_EXIST("1003", "用户ID不存在"),
    REQUEST_PARAM_ERROR("1004", "所需请求参数错误"),
    ENTITY_ALREADY_EXIST("1005", "对象已存在"),
    ENTITY_NOT_EXIST("1006", "对象不存在"),
    FOREIGN_KEY_ERROR("1009", "ID参数有误"),
    PARAM_UNDEFINED("1010", "参数未定义"),
    FILE_TYPE_ILLEGAL("1011", "文件类型不合法"),
    RESOURCE_NOT_FOUND("1012", "资源未找到"),
    SYSTEM_ERROR("1013", "系统异常");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static @Nullable ErrorCode get(String str) {
        for (ErrorCode e : values()) {
            if (e.getCode().equals(str))
                return e;
        }
        return null;
    }
}
