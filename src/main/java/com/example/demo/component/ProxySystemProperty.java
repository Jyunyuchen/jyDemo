package com.example.demo.component;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
@Slf4j
public class ProxySystemProperty {

    @PostConstruct
    public void setProxy() {
        log.info("proxy設定中...");

        log.info("目前的Proxy Host:{}", System.getProperty("http.proxyHost"));
        log.info("目前的Proxy Port:{}", System.getProperty("http.proxyPort"));

        System.clearProperty("http.proxyHost");
        System.clearProperty("http.proxyPort");

        System.setProperty("http.proxyHost","169.57.1.85");
        System.setProperty("http.proxyPort","8123");
        log.info("設定後的Proxy Host:{}", System.getProperty("http.proxyHost"));
        log.info("設定後Proxy Port:{}", System.getProperty("http.proxyPort"));
    }
}
