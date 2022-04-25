package com.example.demo.controller;

import com.example.demo.service.impl.AsynsServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AsyncTestController {

    @Autowired
    AsynsServicesImpl asynsServices;

    @GetMapping("/asyncTest")
    public void test() throws InterruptedException{
        log.info("===================>1");
        asynsServices.asyncMethod01();
        log.info("===================>4");
    }
}
