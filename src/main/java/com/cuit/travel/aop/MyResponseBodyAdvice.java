package com.cuit.travel.aop;

import com.cuit.travel.pojo.response.ResponseData;
import com.cuit.travel.utils.ResponseDataUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.jws.WebResult;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截Controller方法默认返回参数，统一处理返回值/响应体
 */
@ControllerAdvice(basePackages = "com.cuit.travel.controller")
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        long timeDuration = System.currentTimeMillis() - ParamOutAspect.startTime.get();// 计算请求花费的时间
        ResponseData responseData = ResponseDataUtil.buildSuccess(o);
        responseData.setCost(timeDuration);
        return responseData;
    }


    /**
     * 逻辑计算是否执行beforeBodyWrite方法  返回true则执行返回false则不执行
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 全局异常捕获
     *
     * @param response
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseData globalException(HttpServletResponse response, NullPointerException ex) {
        return ResponseDataUtil.buildError("服务器异常!");
    }
}
