package com.hlj.jixi.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 修改原生spring异步线程池的装配
 */

@Configuration //配置类  线程池
@EnableAsync // 开启异步
public class NativeAsyncTaskExecutePool implements AsyncConfigurer {

    private final Logger logger = LoggerFactory.getLogger(NativeAsyncTaskExecutePool.class);

    //注入配置类
    @Autowired
    TaskThreadPoolConfig threadPoolConfig;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(threadPoolConfig.getCorePoolSize());
        threadPool.setMaxPoolSize(threadPoolConfig.getMaxPoolSize());
        threadPool.setKeepAliveSeconds(threadPoolConfig.getKeepAliveSeconds());
        threadPool.setQueueCapacity(threadPoolConfig.getQueueCapacity());
        threadPool.setThreadNamePrefix("MyExecutor2-");
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("MyExecutor2 配置" + threadPoolConfig.toString());
        threadPool.initialize();
        return threadPool;
    }

    /**
     * 异步任务中异常处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            logger.error("===============" + ex.getMessage());
            logger.error("===============" + method.getName());
        };
    }
}
