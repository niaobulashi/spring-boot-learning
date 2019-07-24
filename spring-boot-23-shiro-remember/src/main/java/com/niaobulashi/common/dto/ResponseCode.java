package com.niaobulashi.common.dto;

import com.niaobulashi.common.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-20-shiro
 * @description: 响应码
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 12:31
 */
@Data
@AllArgsConstructor
public class ResponseCode<T> implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    private ResponseCode(StatusEnums responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    private ResponseCode(StatusEnums responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    private ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回成功信息
     * @param data      信息内容
     * @param <T>
     * @return
     */
    public static<T> ResponseCode success(T data) {
        return new ResponseCode<>(StatusEnums.SUCCESS, data);
    }

    /**
     * 返回成功信息
     * @return
     */
    public static ResponseCode success() {
        return new ResponseCode(StatusEnums.SUCCESS);
    }

    /**
     * 返回错误信息
     * @param statusEnums      响应码
     * @return
     */
    public static ResponseCode error(StatusEnums statusEnums) {
        return new ResponseCode(statusEnums);
    }
}
