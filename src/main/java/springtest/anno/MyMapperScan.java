package springtest.anno;

import org.springframework.context.annotation.Import;
import springtest.imports.MyImportBeanDefinitionRegistrar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {
}
