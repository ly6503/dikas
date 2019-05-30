package vip.pryun.dikas.file;

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
 * @date 2019/5/30 15:07
 */
@SpringBootApplication(scanBasePackages = {
        "vip.pryun.dikas.file.controller",
        "vip.pryun.dikas.file.conf",
        "vip.pryun.dikas.service.biz.impl",
})
@MapperScan(basePackages = "vip.pryun.dikas.persistence.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class FileApplication {
    private static final Logger LOG = LoggerFactory.getLogger(FileApplication.class);

    public static void main(String[] args) {
        AppContext.context = SpringApplication.run(FileApplication.class, args);
        String[] activeProfiles = AppContext.context.getEnvironment().getActiveProfiles();
        LOG.info("active profile: {}", Arrays.toString(activeProfiles));
    }

}