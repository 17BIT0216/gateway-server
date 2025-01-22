package com.eazybytes.gateway.server.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/contactSupport")
    public Mono<String> contactSupport()
    {
        return Mono.just("An error occurred, please contact support");
    }
}
