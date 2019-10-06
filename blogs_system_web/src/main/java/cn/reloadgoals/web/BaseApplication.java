package cn.reloadgoals.web;

import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TranbinLee
 * @date 2019/10/3
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.reloadgoals"})
@MapperScan({"cn.reloadgoals.model.mapper","cn.reloadgoals.common.mapper"})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }
}
