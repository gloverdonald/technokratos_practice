package com.technokratos.config;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.*;

@EnableWebMvc
@Configuration
@ComponentScan("com.technokratos")
public class WebWvcConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    private final List<MediaType> supportedTypes = List.of(
            MediaType.IMAGE_JPEG,
            MediaType.IMAGE_PNG,
            MediaType.APPLICATION_OCTET_STREAM
    );

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(byteArrayHttpMessageConverter());

    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        arrayHttpMessageConverter.setSupportedMediaTypes(supportedTypes);
        return arrayHttpMessageConverter;
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftlh");
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }

    @Bean(name = "freemarkerConfiguration")
    public FreeMarkerConfigurer freeMarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/templates/");
        return configurer;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("spring.mail.port"))));

        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.allow8bitmime", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        return mailSender;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(256000000);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SpecificationArgumentResolver());
    }
}
