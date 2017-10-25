package com.fly.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/**
 * Created by jinxiaofei.
 * Time 2017/10/21 下午2:55
 * Desc 文件描述
 */
// 定义一个方面
//@Component
@Aspect
public class LogAspect
{
    // 匹配 org.crazyit.app.service.impl 包下所有类的、
    // 所有方法的执行作为切入点
    @Around("execution(* com.fly.service.impl..*Impl.save*(..))")
    public Object processTx(ProceedingJoinPoint jp)
            throws java.lang.Throwable
    {
        System.out.println("执行目标方法之前，模拟开始事务 ...");
        // 执行目标方法，并保存目标方法执行后的返回值
        Object rvt = jp.proceed();
        System.out.println("执行目标方法之后，模拟结束事务 ...");
        System.out.println( rvt + " 新增的内容");
        return rvt;
    }
}
