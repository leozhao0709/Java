package com.lzhao.girlservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
class HttpAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.lzhao.girlservice.controllers.GirlController.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("pointCut()")
    public void doAfter() {
        logger.info("execution after....");
    }

    @AfterReturning(returning = "object", pointcut = "pointCut()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void afterThrowing(Exception e) {
        logger.error("========异常通知========:" + e);
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("========环绕通知:前========:");
        Object proceed = pjp.proceed();
        logger.info("========环绕通知:后========:");

        return proceed;
    }
}
