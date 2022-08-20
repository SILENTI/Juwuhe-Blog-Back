package com.example.juwuheback.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    private static final String VERSION = "1.0";

    private static final String PACKAGE_PATH = "com.example.juwuheback";

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("juwuhe-blog")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_PATH))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                //标题名
                .title("居無何")
                //接口描述
                .description("居無何的个人博客")
                //接口版本
                .version(VERSION)
                //作者、网站、邮箱
                .contact(new Contact("居無何", "https://www.baidu.com",
                        "fruitbox@outlook.com"))
                .build();
    }
}