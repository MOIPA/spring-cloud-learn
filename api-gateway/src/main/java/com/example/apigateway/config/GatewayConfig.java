package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tr
 * @date 2020/4/13 09:10
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route("path_route2", x -> x.path("/user/getByUsername").uri("http://localhost:8201/user/getUserByname"))
                .build();
    }
}
