package springtest2.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import springtest2.anno.aopLog.MyAopLog;

import java.lang.annotation.Target;

//增强类
@Component("myAdvice")
@Aspect //@Aspect注解是用来标识一个类作为AspectJ切面的一种方式
public class MyAdvice {

    /**
     * 目标：探究AOP中的切入点表达式-execution
     * execution主要根据方法的返回值、包名、类名、方法名、方法参数等信息来匹配，语法为：
     * execution(访问修饰符？ 返回值 包名.类名.?方法名(方法参数) throws 异常?)
     * 可以使用通配符描述切入点
     *      *：单个独立的任意符号，可以通配任意返回值、包名、类名、方法名、任意类型的一个参数，也可以通配包、类、方法名的一部分
     *      execution(* com.*.service.*.update*(*))
     *      ..:多个连续的任意符号，可以通配任意层级的包，或者任意类型、任意个数的参数
     *      execution(* com.itheima..DeptService.*(..))
     * 注意事项：
     *      根据业务需要，可以使用 且(&&)、或(||)、非(!)来组合比较复杂的切入点表达式
     */


    @Pointcut("execution(void springtest2.service.impl.UserServiceImpl.show1() )")
    private void pointCut(){};


    //@Before("pointCut()")
    public void beforeAdvice(){
        System.out.println("前置增强");
    }
    //@AfterReturning("@annotation(springtest2.anno.aopLog.MyAopLog)")
    //@AfterReturning("execution(void springtest2..show1())")
    //@AfterReturning("execution(* *..*.*(..))")
    public void afterAdvice(){
        System.out.println("后置增强  一切");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知");
        System.out.println(point.getSignature()+"123");

        long begin = System.currentTimeMillis();
        Object proceed = point.proceed();
        Thread.sleep(10);
        long end = System.currentTimeMillis();
        long ado = end - begin;

        System.out.println(point.getTarget()+"执行耗时"+(end-begin));
        return proceed;
    }


}
