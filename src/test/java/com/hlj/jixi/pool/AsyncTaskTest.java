package com.hlj.jixi.pool;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 测试springboot中线程池使用
 */
public class AsyncTaskTest {

    AsyncTask asyncTask;

    @Before
    public void setup() {
        asyncTask = new AsyncTask();
    }

    @Test
    public void testPoolTask() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            asyncTask.doTask1(i);
            asyncTask.doTask2(i);
            ListenableFuture<String> listenableFuture = asyncTask.doTask3(i);
            System.out.println(listenableFuture.get());
        }
    }

}