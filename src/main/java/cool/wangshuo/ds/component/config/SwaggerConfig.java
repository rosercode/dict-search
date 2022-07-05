package cool.wangshuo.ds.component.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@EnableKnife4j
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)  //是否开启 (true 开启,false隐藏。生产环境建议隐藏)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.dict.controller"))
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .paths(PathSelectors.any()) //指定路径处理PathSelectors.any()代表所有的路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("字典查询信息接口文档") //设置文档标题(API名称)
                .description("一个关于常见的字典查询接口，提供常见的字典查询服务【不定期更新】") //文档描述
//                .termsOfServiceUrl("http://localhost:5446/") //服务条款URL
                .version("1.0.0") //版本号
                .build();
    }
}