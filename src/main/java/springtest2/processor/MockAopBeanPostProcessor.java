package springtest2.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import springtest2.advice.MyAdvice;

import java.lang.reflect.Proxy;

//@Component
public class MockAopBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //对userService中的show1和show2方法增强
        //增强方法在myadvice中
        if (bean.getClass().getPackage().getName().equals("springtest2.service.impl")) {
            //如果是在这个包下的bean 就生成增强代理
            Object beanProxy = Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        //通过Aware接口获取一个applicationContext对象 获取增强对象
                        MyAdvice myAdvice = applicationContext.getBean(MyAdvice.class);
                        //执行增强对象的before方法
                        myAdvice.beforeAdvice();

                        Object result = method.invoke(bean, args);
                        //执行增强对象的after方法
                        myAdvice.afterAdvice();
                        return result;
                    }

            );
            return beanProxy;
        }


        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
