package com.fly.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jinxiaofei on 16/10/20.
 */
public class App {
    private static final Logger LOGGER= LoggerFactory.getLogger(App.class);
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
    public void start() throws InterruptedException {
        classPathXmlApplicationContext.start();
        LOGGER.info("启动完成");
        try {
            synchronized(this.getClass()) {
                this.getClass().wait();
            }
        } catch (InterruptedException e) {
            throw e;
        }
    }
}

