package com.hlj.jixi.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * 需要异步线程执行的任务
 */
@Component
public class AsyncTask {
    private final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    /**
     * 配置自定义线程池的方法名
     */
    @Async("myTaskAsyncPool")
    public void doTask1(int i) {
        logger.info("Task " + i + " start");
    }

    /**
     * 使用默认的线程池
     */
    @Async
    public void doTask2(int i) {
        logger.info("Task2_Native " + i + " start");
    }

    /**
     * 使用默认的线程池并返回参数
     */
    @Async
    public ListenableFuture<String> doTask3(int i) {
        logger.info("Task3-返回值" + i + "started.");
        return new AsyncResult<>(i + "");
    }


}
