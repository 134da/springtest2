package springtest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springtest.anno.MyMapperScan;
import springtest.beans.OtherBean;
import springtest.imports.MyImportBeanDefinitionRegistrar;
import springtest.imports.MyImportSelector;

import javax.sql.DataSource;

@Configuration  //标志当前类是一个配置类 + @Component
@ComponentScan("springtest")   //扫描范围
@PropertySource("classpath:jdbc.properties")  //属性资源导入
//@Import(OtherBean.class)  //加载其他配置类
//@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
@MyMapperScan
@MapperScan("springtest.mapper")

public class SpringConfig {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }




}
