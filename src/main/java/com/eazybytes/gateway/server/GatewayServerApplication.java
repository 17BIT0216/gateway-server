package com.eazybytes.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator eazyBankRouteConfig(RouteLocatorBuilder builder) {

		return builder.routes()
				.route( r -> r.path("/eazybank/accounts/**")
						.filters(f->f.rewritePath("/eazybank/accounts/(?<segment>.*)", "//${segment}")
								.addResponseHeader("X-ResponseTIme", LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))
				.route( r -> r.path("/eazybank/cards/**")
				        .filters(f->f.rewritePath("/eazybank/cards/(?<segment>.*)", "//${segment}")
								.addResponseHeader("X-ResponseTIme", LocalDateTime.now().toString()))
				        .uri("lb://CARDS"))
				.build();
	}
}
