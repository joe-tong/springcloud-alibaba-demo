package com.tpp.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 这个类上千万不要添加@Configuration,不然会被作为全局配置文件共享
 */
public class ProductCenterFeignConfig {

    @Bean
    public Logger.Level level() {
        //return Logger.Level.FULL;
        //return Logger.Level.HEADERS;
        return Logger.Level.BASIC;
        //return Logger.Level.NONE;
    }


}
