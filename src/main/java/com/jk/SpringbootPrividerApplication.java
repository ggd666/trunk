package com.jk;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@MapperScan("com.jk.service.*")
@ImportResource(value = {"classpath:dubbo-provider.xml"})
public class SpringbootPrividerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPrividerApplication.class, args);

    }

    @Bean
    public Queue getQueue(){
        return  new  Queue("1804A");
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        FastJsonHttpMessageConverter converter = fastConverter;
        return new HttpMessageConverters(converter);
    }




}