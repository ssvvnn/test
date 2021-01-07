package com.destiny.soul.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zhuhaifeng
 * @since 2020-07-02
 */

@Aspect
@Component
@Order(2)
public class LogRespect {
    private static final Logger log = LoggerFactory.getLogger(LogRespect.class);

    @Pointcut("execution(* com.destiny.soul.controller..*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("hhhh");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        log.info("URL : " + request.getRequestURL());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("REMOTE_ADDR : " + request.getRemoteAddr());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        log.info("USER_AGENT : " + request.getHeader("User-Agent"));
    }

    @AfterReturning(value = "webLog()", returning = "result")
    public void doAfterReturning(Object result) throws Throwable {
        log.info("RESPONSE : " + result);
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = proceedingJoinPoint.proceed();
        Long takeTime = System.currentTimeMillis() - startTime;
        log.info("耗时: " + takeTime);
        return ob;
    }
}
