package com.zhang.ssmschoolshop.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 拦截所有路径
                .excludePathPatterns("/admin/login", "/admin/confirmLogin",
                        "/","/login","/loginconfirm","/register","/registerresult","/logout","/order*","/cart*","/search","/category*","/detail","/main","/information","/info/**",
                        "/show*","/save*","/add*","/collect","/delete*/**","/insert*","/finish*","/error",
                        "/css/**","/js/**","/fonts/**","/image/**","/info/**",/*排除登录和注册接口*/
                        "/test/*","/admin/test/*"//后台或前台的测试
                );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        String pathPatterns="/pictures/**";
        String pathAbsolute="file:E:/UC download/";
        if (!os.toLowerCase().startsWith("windows")){
            // todo mac需要修改地址
            pathAbsolute="file:/usr/upload/";
        }
        registry.addResourceHandler(pathPatterns).addResourceLocations(pathAbsolute);
    }

}