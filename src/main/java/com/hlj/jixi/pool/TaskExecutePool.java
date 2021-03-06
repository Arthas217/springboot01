package com.hlj.jixi.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池
 */
@Configuration //配置类  线程池
@EnableAsync // 开启异步
public class TaskExecutePool {

    // 线程池配置
    @Autowired
    TaskThreadPoolConfig threadPoolConfig;

    @Bean
    public Executor myTaskAsyncPool(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(threadPoolConfig.getCorePoolSize());
        threadPool.setMaxPoolSize(threadPoolConfig.getMaxPoolSize());
        threadPool.setKeepAliveSeconds(threadPoolConfig.getKeepAliveSeconds());
        threadPool.setQueueCapacity(threadPoolConfig.getQueueCapacity());
        threadPool.setThreadNamePrefix("MyExecutor1-");
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("MyExecutor1 配置" + threadPoolConfig.toString());
        threadPool.initialize();
        return threadPool;
    }
}
