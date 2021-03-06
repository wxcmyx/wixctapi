package com.wixct.blogapi.config;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//    /** 解决跨域问题 **/
//    public void addCorsMappings(CorsRegistry registry) ;
//    /** 添加拦截器 **/
//    void addInterceptors(InterceptorRegistry registry);
//    /** 这里配置视图解析器 **/
//    void configureViewResolvers(ViewResolverRegistry registry);
//    /** 配置内容裁决的一些选项 **/
//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    /** 静态资源处理 **/
//    void addResourceHandlers(ResourceHandlerRegistry registry);
//    /** 默认静态资源处理器 **/
//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

/**
 * 配置spring mvc
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 设置错误页面
     */
    private static class MyErrorPageRegistrar implements ErrorPageRegistrar {

        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/"+HttpStatus.BAD_REQUEST.value()));
            registry.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/"+HttpStatus.UNAUTHORIZED.value()));
            registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/error/403"));
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
            registry.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405"));
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_ACCEPTABLE, "/error/406"));
            registry.addErrorPages(new ErrorPage(HttpStatus.PROXY_AUTHENTICATION_REQUIRED, "/error/407"));
            registry.addErrorPages(new ErrorPage(HttpStatus.REQUEST_TIMEOUT, "/error/408"));
            registry.addErrorPages(new ErrorPage(HttpStatus.CONFLICT, "/error/409"));
            registry.addErrorPages(new ErrorPage(HttpStatus.GONE, "/error/410"));
            registry.addErrorPages(new ErrorPage(HttpStatus.LENGTH_REQUIRED, "/error/411"));
            registry.addErrorPages(new ErrorPage(HttpStatus.PRECONDITION_FAILED, "/error/412"));
            registry.addErrorPages(new ErrorPage(HttpStatus.PAYLOAD_TOO_LARGE, "/error/413"));
            registry.addErrorPages(new ErrorPage(HttpStatus.URI_TOO_LONG, "/error/414"));
            registry.addErrorPages(new ErrorPage(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "/error/415"));
            registry.addErrorPages(new ErrorPage(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, "/error/416"));
            registry.addErrorPages(new ErrorPage(HttpStatus.EXPECTATION_FAILED, "/error/417"));
            registry.addErrorPages(new ErrorPage(HttpStatus.DESTINATION_LOCKED, "/error/421"));
            registry.addErrorPages(new ErrorPage(HttpStatus.UNPROCESSABLE_ENTITY, "/error/422"));
            registry.addErrorPages(new ErrorPage(HttpStatus.LOCKED, "/error/423"));
            registry.addErrorPages(new ErrorPage(HttpStatus.FAILED_DEPENDENCY, "/error/424"));
            registry.addErrorPages(new ErrorPage(HttpStatus.UPGRADE_REQUIRED, "/error/426"));
            registry.addErrorPages(new ErrorPage(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "/error/451"));
            registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_IMPLEMENTED, "/error/501"));
            registry.addErrorPages(new ErrorPage(HttpStatus.BAD_GATEWAY, "/error/502"));
            registry.addErrorPages(new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/error/503"));
            registry.addErrorPages(new ErrorPage(HttpStatus.GATEWAY_TIMEOUT, "/error/504"));
            registry.addErrorPages(new ErrorPage(HttpStatus.HTTP_VERSION_NOT_SUPPORTED, "/error/505"));
            registry.addErrorPages(new ErrorPage(HttpStatus.VARIANT_ALSO_NEGOTIATES, "/error/506"));
            registry.addErrorPages(new ErrorPage(HttpStatus.INSUFFICIENT_STORAGE, "/error/507"));
            registry.addErrorPages(new ErrorPage(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED, "/error/509"));
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_EXTENDED, "/error/510"));
        }

    }
    /**
     * 配置cors跨域访问
     * @return
     */
    @Override
    public void addCorsMappings(CorsRegistry registry){
//        System.out.println("进入跨域设置也么！！");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true);
    }
    @Bean(name = "jfinalViewResolver")
    public JFinalViewResolver getJFinalViewResolver() {
        JFinalViewResolver jfr = new JFinalViewResolver();
        // setDevMode 配置放在最前面
        jfr.setDevMode(true);

        // 使用 ClassPathSourceFactory 从 class path 与 jar 包中加载模板文件
        jfr.setSourceFactory(new ClassPathSourceFactory());

        // 在使用 ClassPathSourceFactory 时要使用 setBaseTemplatePath
        // 代替 jfr.setPrefix("/view/")
        JFinalViewResolver.engine.setBaseTemplatePath("/view/");

        jfr.setSuffix(".html");
        jfr.setContentType("text/html;charset=UTF-8");
        jfr.setOrder(0);
//        jfr.addSharedFunction("/view/common/_layout.html");
//        jfr.addSharedFunction("/view/common/_paginate.html");
        return jfr;
    }

    /**
     * 注册错误页面
     * @return
     */
    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new MyErrorPageRegistrar();
    }

}
