package com.example.aopIntercepterFilter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NormalAopConf {

    /**
     * @ Pointcut("execution(* com.example.service..*.*(..))")
     *             第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，
     *             上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，
     *             第二个..表示方法的任意参数个数
     * */
    @Pointcut("execution(* com.example.aopIntercepterFilter.TestAopMethod.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("do something before!");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("do something after");
    }

    @AfterReturning(pointcut="pointCut()",returning="returnVal")
    public void afterReturn(JoinPoint joinPoint,Object returnVal){
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    //此方法不建议和Around同时使用
    /*@AfterThrowing(pointcut="pointCut()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }*/

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("do around before...");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("do around after...");
    }


}
