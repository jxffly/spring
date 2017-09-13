package com.fly.annotask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class QuartzJob {
    private static final Logger LOGGER= LoggerFactory.getLogger(QuartzJob.class);
    public QuartzJob(){
        System.out.println("Quartzjob创建成功");
    }
    @Scheduled(cron = "0/5 * *  * * ? ")
    public void run(){
        System.out.println("Quartz基于注解的启动");
        LOGGER.info("基于注解的任务调度");
    }
}