package vip.pryun.dikas.web;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import vip.pryun.dikas.common.context.AppContext;

import java.util.Arrays;

/**
 * @author 59941
 * @date 2019/5/27 11:47
 */
@SpringBootApplication(scanBasePackages ={
        "vip.pryun.dikas.web.controller",
        "vip.pryun.dikas.web.conf",
        "vip.pryun.dikas.service.biz.impl",
} )
@MapperScan(basePackages = "vip.pryun.dikas.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class WebApplication {
    private static final Logger LOG = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
        AppContext.context = SpringApplication.run(WebApplication.class, args);
        String[] activeProfiles = AppContext.context.getEnvironment().getActiveProfiles();
        LOG.info("active profile: {}", Arrays.toString(activeProfiles));
    }

}