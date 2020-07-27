
package com.testingspring.springtest.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


import javax.swing.text.DateFormatter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@ComponentScan
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer  {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry
                .addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/static/fonts/");
    }


    @Bean
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setPrefix("templates/");
        viewResolver.setSuffix(".ftlh");
        return viewResolver;
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
        registry.viewResolver(viewResolver());
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(converter -> {
            if (converter instanceof AbstractHttpMessageConverter) {
                ((AbstractHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
                if (converter instanceof StringHttpMessageConverter) {
                    ((StringHttpMessageConverter) converter).setWriteAcceptCharset(false);
                }
            } else if (converter instanceof FormHttpMessageConverter) {
                ((FormHttpMessageConverter) converter).setCharset(StandardCharsets.UTF_8);
                ((FormHttpMessageConverter) converter).setMultipartCharset(StandardCharsets.UTF_8);
            }
        });
    }
}




