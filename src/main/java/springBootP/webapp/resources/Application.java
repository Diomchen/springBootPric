package springBootP.webapp.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//这里是继承了Spring Boot提供的Servlet初始化器SpringBootServletInitializer
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    //这里是重写了SpringBootServletInitializer的Configure（）方法
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }
}
