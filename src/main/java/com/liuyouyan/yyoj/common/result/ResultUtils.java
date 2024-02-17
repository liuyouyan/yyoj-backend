package com.liuyouyan.yyoj.common.result;

import com.liuyouyan.yyoj.common.enumeration.ErrorCodeEnum;

/**
 * 返回工具类
 *
 * @author <a href="https://liuyouyan.com">刘有颜</a>
 * @from <a href="https://liuyouyan.com">刘有颜的博客</a>
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败
     *
     * @param errorCodeEnum
     * @return
     */
    public static BaseResponse error(ErrorCodeEnum errorCodeEnum) {
        return new BaseResponse<>(errorCodeEnum);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static BaseResponse error(int code, String message) {
        return new BaseResponse(code, null, message);
    }

    /**
     * 失败
     *
     * @param errorCodeEnum
     * @return
     */
    public static BaseResponse error(ErrorCodeEnum errorCodeEnum, String message) {
        return new BaseResponse(errorCodeEnum.getCode(), null, message);
    }
}
