package com.cuit.travel.aop;

import com.cuit.travel.pojo.response.ResponseData;
import com.cuit.travel.utils.ResponseDataUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ParamOutAspect {
    //统计请求的处理时间
    public static ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切入点
     * 注解的参数就是对controller下的所有的类的所有方法进行切面
     */
    @Pointcut("execution(* com.cuit.travel.controller.*.*(..))")
    public void log() {
//        System.out.println("qiedian 方法");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ParamOutAspect.startTime.set(System.currentTimeMillis());//设置请求开始的时间
//        System.out.println("before 方法");
    }
//    @AfterReturning(returning = "ret", pointcut = "log()")
//    public Object doAfterReturning(Object ret) {
//        System.out.println("after 方法");
////        long timeDuration = System.currentTimeMillis() - startTime.get();// 计算请求花费的时间
////        ResponseData responseData = ResponseDataUtil.buildSuccess(ret);
////        responseData.setCost(timeDuration);
////        System.out.println(responseData);
////        return responseData;
//        return null;
//    }

}
