package com.fly.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jinxiaofei on 16/10/20.
 */
public class CheckOnlineTask {
    private static final Logger LOGGER= LoggerFactory.getLogger(CheckOnlineTask.class);
    private int runTime=1;
    public void doTask(){
        LOGGER.info("{}开始第{}次的任务",this.getClass(),runTime++);
    }
}
