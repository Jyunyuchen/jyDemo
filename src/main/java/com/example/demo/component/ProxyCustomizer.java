package com.example.demo.component;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class ProxyCustomizer implements RestTemplateCustomizer {

   final String PROXY_SERVER_HOST = "169.57.1.85";
    final int PROXY_SERVER_PORT = 8123;

    @Override
    public void customize(RestTemplate restTemplate) {
        HttpHost proxy = new HttpHost(PROXY_SERVER_HOST, PROXY_SERVER_PORT);
        HttpClient httpClient = HttpClientBuilder.create()
                .setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
                    @Override
                    public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                        return super.determineProxy(target, request, context);
                    }
                })
                .build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}