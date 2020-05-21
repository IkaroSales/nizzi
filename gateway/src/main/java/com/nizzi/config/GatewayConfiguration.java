package com.nizzi.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfiguration {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("http://httpbin.org:80"))
				.route(p -> p
						.path("/clientes/*")
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("http://localhost:8081"))
				.route(p -> p
						.path("*.hystrix.com")
						.filters(f -> f.hystrix(config -> config.setName("cmd")))
						.uri("http://httpbin.org:80"))
				.build();
	}
}
