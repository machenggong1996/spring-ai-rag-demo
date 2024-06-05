package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.JettyClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestClientConfig {

//    @Bean
//    public ClientHttpRequestFactory clientRequestFactory() {
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        // 设置连接超时时间（单位：毫秒）
//        requestFactory.setConnectTimeout(30000);
//        // 设置读取超时时间（单位：毫秒）
//        requestFactory.setReadTimeout(30000);
//
//        return requestFactory;
//    }

//    @Bean
//    public RestTemplate restTemplate() {
//        JettyClientHttpRequestFactory requestFactory = new JettyClientHttpRequestFactory();
//        // 设置连接超时时间（单位：毫秒）
//        requestFactory.setConnectTimeout(30000);
//        // 设置读取超时时间（单位：毫秒）
//        requestFactory.setReadTimeout(30000);
//
//        return new RestTemplate(requestFactory);
//    }

    @Bean
    @Scope("prototype")
    RestClient.Builder restClientBuilder(RestClientBuilderConfigurer restClientBuilderConfigurer) {
        ClientHttpRequestFactorySettings settings = new ClientHttpRequestFactorySettings(Duration.ofSeconds(30),Duration.ofSeconds(30),null, null);
        RestClient.Builder builder = RestClient.builder()
                .requestFactory(ClientHttpRequestFactories.get(settings));
        return restClientBuilderConfigurer.configure(builder);
    }
}