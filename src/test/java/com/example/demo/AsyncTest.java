package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootTest
@EnableAsync
@Slf4j
public class AsyncTest {

    /**
     * 兩個方法使用同一個@Async看是否會是同步的
     */
    @Test
    void test01() throws InterruptedException{
        log.info("===================>1");
        this.asyncMethod01();
        log.info("===================>4");
    }

    @Async("syncFileExecutor")
    void asyncMethod01() throws InterruptedException{
        log.info("===================>2");
        Thread.sleep(5000);
        this.asyncMethod02();
    }

    @Async("syncFileExecutor")
    void asyncMethod02(){
        log.info("===================>3");
    }

}


