/**
 * Copyright (C), 2018-2019, XXX有限公司 FileName: SwaggerConfig Author:   pwb Date:     2019/7/12 10:44 Description: swagger2配置类 History:
 * <author>          <time>          <version>          <desc>
 * frank           修改时间           1.0.0              ycypApp
 */
package com.example.demo.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 〈swagger2配置类〉
 *
 * @author pwb
 * @create 2019/7/12
 * @since 1.0.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enable;

    /*--------------------------------------------------------------------------------------------------------------------------------------*/
    @Bean
    public Docket commonRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .useDefaultResponseMessages(false)
                .apiInfo(commonInfo())
                .groupName("通用接口服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller.common"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo commonInfo() {
        return new ApiInfoBuilder()
                .title("天气-通用接口服务")
                .description("通用接口服务API")
                .termsOfServiceUrl("http://localhost:8088/")
                .contact(new Contact("pwb", "www.baidu.com", "925234379@qq.com"))
                .version("1.0")
                .build();
    }

    /*--------------------------------------------------------------------------------------------------------------------------------------*/
    @Bean
    public Docket adminRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .useDefaultResponseMessages(false)
                .apiInfo(adminInfo())
                .groupName("管理端接口服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller.admin"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo adminInfo() {
        return new ApiInfoBuilder()
                .title("天气-管理端接口服务")
                .description("管理端接口服务API")
                .termsOfServiceUrl("http://localhost:8088/")
                .contact(new Contact("pwb", "www.baidu.com", "925234379@qq.com"))
                .version("1.0")
                .build();
    }

    /*--------------------------------------------------------------------------------------------------------------------------------------*/
    @Bean
    public Docket appRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .useDefaultResponseMessages(false)
                .apiInfo(appInfo())
                .groupName("应用端接口服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller.app"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo appInfo() {
        return new ApiInfoBuilder()
                .title("天气-应用端接口服务")
                .description("应用端接口服务API")
                .termsOfServiceUrl("http://localhost:8088/")
                .contact(new Contact("pwb", "www.baidu.com", "925234379@qq.com"))
                .version("1.0")
                .build();
    }
}
