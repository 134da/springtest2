package springtest2.test;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibTest {
    public static void main(String[] args) {

        //CGlib基于父类的生成Proxy

        //目标对象
        Target target = new Target();

        //通知对象
        MyAdvice4 myAdvice4 = new MyAdvice4();

        //编写一个CGlib代码
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Target.class); //生成的代理对象就是它的子类
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            //相当于JDK的Proxy的invoke方法
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                myAdvice4.before();
                Object res = method.invoke(target, args);
                myAdvice4.after();
                return res;
            }
        });
        //生成代理对象
        Target proxy = (Target) enhancer.create();
        proxy.show();
    }
}
