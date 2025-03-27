package springtest.beans;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springtest.dao.UserDao;

import javax.sql.DataSource;


public class OtherBean {

    @Bean("dataSource")
    public DataSource dataSource(
            @Value("$jdbc.driver") String driverClassName,
            UserDao userdao
    ){
        DruidDataSource dataSource = new DruidDataSource();
        //设置四个基本参数
        dataSource.setDriverClassName(driverClassName);
/*        System.out.println(userdao);*/
        System.out.println(dataSource);
        return dataSource;
    }

}
