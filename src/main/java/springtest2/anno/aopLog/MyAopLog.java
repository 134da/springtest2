package springtest2.anno.aopLog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //指定这个注解什么时候生效 表示运行时生效
@Target(ElementType.METHOD) //指定这个注解应该在什么地方  METHOD代表应该放在方法上
public @interface MyAopLog {
}
