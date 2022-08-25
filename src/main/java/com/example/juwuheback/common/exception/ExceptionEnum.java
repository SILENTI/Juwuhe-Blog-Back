package com.example.juwuheback.common.exception;


public enum ExceptionEnum {

    /**
     * ======================================== 分隔符 ========================================
     **/

    /*-------------------- 系统相关 1-49 --------------------*/
    SUCCESS(1, "操作成功", true),
    FAIL(2, "操作失败", false),
    SYSTEM_ERROR(3, "系统错误", false),

    UNKNOWN_ERROR(4, "未知错误", false),

    DATABASE_OPERATION_ERROR(5, "数据库操作失败", false),

    /*-------------------- User 50-49 --------------------*/
    USER_USERNAME_PASSWORD_ERROR(50, "用户名或密码错误", false),
    USER_USERNAME_IS_NOT_EXIST_ERROR(50, "当前用户不存在", false);

    /**
     * ======================================== 分隔符 ========================================
     **/

    private Integer code;

    private String message;

    private boolean success;

    ExceptionEnum() {
    }

    ExceptionEnum(Integer code, String message, boolean SUCCESS) {
        this.code = code;
        this.message = message;
        this.success = SUCCESS;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
