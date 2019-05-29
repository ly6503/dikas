package vip.pryun.dikas.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@Profile("swagger")
public class SwaggerConfig {
    private static final ApiInfo API_INFO = new ApiInfo(
            "项目接口",
            "项目SWAGGER接口文档",
            "1.0.0",
            null,
            null,
            null,
            null,
            Collections.emptyList()
    );

    @Bean
    public Docket docket(ServletContext servletContext) {
        SecurityContext securityContext = SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/(web|api)/.*")).build();
        ApiKey apiKey = new ApiKey("xkey", "X-Auth-Token", "header");

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return super.getApplicationBasePath();
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.ryan1h.sb.template.web.api.controller"))
                .build()
                .securitySchemes(newArrayList(apiKey))
                .securityContexts(newArrayList(securityContext));
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("xkey", authorizationScopes));
    }
}
