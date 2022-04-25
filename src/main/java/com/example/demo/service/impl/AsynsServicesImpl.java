package com.example.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsynsServicesImpl {

    @Autowired
    private BeanFactory beanFactory;

    /**
     * 同一個類裡面呼叫非同步方法不生效：原因預設類內的方法呼叫不會被aop攔截，即呼叫方和被呼叫方是在同一個類中，是無法產生切面的，該物件沒有被Spring容器管理。即@Async方法不生效。
     *
     * 解決辦法：如果要使同一個類中的方法之間呼叫也被攔截，需要使用spring容器中的例項物件，而不是使用預設的this，因為通過bean例項的呼叫才會被spring的aop攔截
     *
     * 本例使用方法：AsyncService asyncService  = context.getBean(AsyncService.class);     然後使用這個引用呼叫本地的方法即可達到被攔截的目的
     * @throws InterruptedException
     */
    @Async("syncFileExecutor1")
    public void asyncMethod01() throws InterruptedException{
        log.info("===================>2");
        AsynsServicesImpl bean = beanFactory.getBean(AsynsServicesImpl.class);
        bean.asyncMethod02();
        log.info("===================>3");
    }

    @Async("syncFileExecutor2")
    public void asyncMethod02() throws InterruptedException{
        Thread.sleep(5000);
        log.info("===================>5");
    }
}
