package com.example.juwuheback.common.exception;

import com.example.juwuheback.common.domain.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * Exception 处理
     */
    @ExceptionHandler(Exception.class)
    public ResponseDTO ControllerError(Exception e) {
        return new ResponseDTO(ExceptionEnum.SYSTEM_ERROR);
    }

    /**
     * 参数校验的异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseDTO.fail(ExceptionEnum.SYSTEM_ERROR, message);
    }
}