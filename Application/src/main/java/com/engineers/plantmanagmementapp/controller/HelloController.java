package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.HelloHandler;
import com.engineers.plantmanagmementapp.rest.hello.specification.api.HelloApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * <p>
 * Created on: 2023-10-17
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController implements HelloApi {

    private final HelloHandler helloHandler;

    @Override
    public ResponseEntity<String> sayHello(final String name) {
        return ResponseEntity.ok(helloHandler.handleHello(name));
    }
}
