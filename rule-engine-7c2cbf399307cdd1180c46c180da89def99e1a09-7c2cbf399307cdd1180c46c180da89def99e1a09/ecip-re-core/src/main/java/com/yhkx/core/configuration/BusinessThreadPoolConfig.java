package com.yhkx.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

/**
 * Spring官方的异步多线程池
 * corePoolSize 核心线程数
 * maxPoolSize 最大线程数
 * queueCapcity 队列大小
 * keepAliveSeconds 线程最大空闲时间
 * <p>
 * 使用方式：
 * 无返回值的任务使用execute(Runnable)
 * 有返回值的任务使用submit(Runnable)
 * <p>
 * 内部流程：
 * 如果当前运行的线程数小于corePoolSize，那么就创建线程来执行任务（执行时需要获取全局锁）。
 * 如果运行的线程大于或等于corePoolSize，那么就把task加入BlockQueue。
 * 如果创建的线程数量大于BlockQueue的最大容量，那么创建新线程来执行该任务。
 * 如果创建线程导致当前运行的线程数超过maximumPoolSize，就根据饱和策略来拒绝该任务。
 * 也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，
 * 如果三者都满了，使用handler处理被拒绝的任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
 *
 * 关闭线程：
 * shutdown
 */
@Configuration
public class BusinessThreadPoolConfig {

    @Value("${threadpool.corepoolsize}")
    int corePoolSize;

    @Value("${threadpool.maxpoolsize}")
    int maxPoolSize;

    @Bean
    public Executor myTaskAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(300);
        executor.setKeepAliveSeconds(600);
        executor.setThreadNamePrefix("async-thread-pool");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BusinessThreadPoolConfig businessThreadPoolConfig = new BusinessThreadPoolConfig();
        businessThreadPoolConfig.corePoolSize = 4;
        businessThreadPoolConfig.maxPoolSize = 200;
        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) businessThreadPoolConfig.myTaskAsyncPool();

        Future<String> submit = executor.submit(new CallableImpl());
        out.println("callable reuslt=" + submit.get());

        executor.submit(new RunnableImpl());
    }
}

class CallableImpl implements Callable<String>{
    @Override
    public String call() throws Exception {
        out.println("CallableImpl start!");
        return "CallableImpl";
    }
}

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        out.println("RunnableImpl start!");
    }
}
