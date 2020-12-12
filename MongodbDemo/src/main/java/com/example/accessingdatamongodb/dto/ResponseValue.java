package com.example.accessingdatamongodb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author hu
 */
@ApiModel("通用响应对象")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseValue<T> {

    @ApiModelProperty(value = "响应状态", dataType = "String")
    private final @NotNull
    String result;
    @ApiModelProperty(value = "返回码", dataType = "String")
    private final @Nullable String errorCode;
    @ApiModelProperty(value = "提示信息", dataType = "String")
    private final @Nullable String errormessage;
    @ApiModelProperty(value = "响应内容", dataType = "String")
    private final @Nullable T payload;

    public ResponseValue() {
        this.result = "failure";
        this.errorCode = null;
        this.errormessage = null;
        this.payload = null;

    }

    private ResponseValue(@NotNull String result, @NotNull String errorCode, @NotNull String errormessage, @Nullable T payload) {
        this.result = result;
        this.errorCode = errorCode;
        this.errormessage = errormessage;
        this.payload = payload;
    }

    public static <T> @NotNull ResponseValue<T> success(@Nullable T payload) {
        return new ResponseValue<>("success", "0", "", payload);
    }

    public static <T> @NotNull ResponseValue<T> fail(@NotNull ErrorCode code) {
        return new ResponseValue<>("failure", code.getCode(), code.getMessage(), null);
    }

    public static <T> @NotNull ResponseValue<T> fail(@NotNull String code, @NotNull String message) {
        return new ResponseValue<>("failure", code, message, null);
    }

    public @NotNull String getResult() {
        return result;
    }

    public @Nullable String getErrorCode() {
        return errorCode;
    }

    public @Nullable String getErrorMessage() {
        return errormessage;
    }

    public @Nullable T getPayload() {
        return payload;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "0".equals(errorCode);
    }
}
