package com.example.juwuheback.common.domain;

import com.example.juwuheback.common.exception.ExceptionEnum;
import lombok.Data;

@Data
public class ResponseDTO<T> {

    private Integer code;

    private String message;

    private boolean success;

    private T date;

    public ResponseDTO() {
    }

    public ResponseDTO(Integer code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public ResponseDTO(Integer code, String message, boolean success, T date) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.date = date;
    }

    public ResponseDTO(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.success = exceptionEnum.isSuccess();
        this.message = exceptionEnum.getMessage();
    }

    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO<>(ExceptionEnum.SUCCESS);
    }

    public static <T> ResponseDTO<T> success(T date) {
        return new ResponseDTO<>(ExceptionEnum.SUCCESS).setData(date);
    }

    public static <T> ResponseDTO<T> fail() {
        return new ResponseDTO(ExceptionEnum.FAIL);
    }

    public static <T> ResponseDTO<T> fail(ExceptionEnum exceptionEnum) {
        return new ResponseDTO(exceptionEnum);
    }

    public static <T> ResponseDTO<T> fail(ExceptionEnum exceptionEnum, String message) {
        return new ResponseDTO(exceptionEnum).setMessage(message);
    }

    public ResponseDTO setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseDTO setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public ResponseDTO setData(T data) {
        this.date = data;
        return this;
    }

}
