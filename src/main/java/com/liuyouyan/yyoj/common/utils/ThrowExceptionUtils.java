package com.liuyouyan.yyoj.common.utils;

import com.liuyouyan.yyoj.common.exception.BusinessException;
import com.liuyouyan.yyoj.common.enumeration.ErrorCodeEnum;

/**
 * 抛异常工具类
 *
 * @author <a href="https://liuyouyan.com">刘有颜</a>
 * @from <a href="https://liuyouyan.com">刘有颜的博客</a>
 */
public class ThrowExceptionUtils {

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCodeEnum
     */
    public static void throwIf(boolean condition, ErrorCodeEnum errorCodeEnum) {
        throwIf(condition, new BusinessException(errorCodeEnum));
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCodeEnum
     * @param message
     */
    public static void throwIf(boolean condition, ErrorCodeEnum errorCodeEnum, String message) {
        throwIf(condition, new BusinessException(errorCodeEnum, message));
    }
}
