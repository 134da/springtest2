package springtest2.advice;


import org.springframework.stereotype.Component;

//增强类
@Component("myAdvice")
public class MyAdvice {
    public void beforeAdvice(){
        System.out.println("前置增强");
    }
    public void afterAdvice(){
        System.out.println("后置增强");
    }
}
