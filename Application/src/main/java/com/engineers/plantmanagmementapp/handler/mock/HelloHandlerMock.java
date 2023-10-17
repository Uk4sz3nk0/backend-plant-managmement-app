package com.engineers.plantmanagmementapp.handler.mock;

import com.engineers.plantmanagmementapp.handler.HelloHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelloHandlerMock implements HelloHandler {

    @Override
    public String handleHello(final String name) {
        return "Hello " + name;
    }
}
