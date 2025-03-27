package springtest2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import springtest.anno.MyMapperScan;

/**
 * @author 134da
 */
@Configuration  //标志当前类是一个配置类 + @Component
@ComponentScan("springtest2")   //扫描范围
@EnableAspectJAutoProxy //用于启用对AspectJ风格的切面的支持
public class SpringConfig {
}
