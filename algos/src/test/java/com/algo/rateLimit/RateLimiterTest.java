package com.algo.rateLimit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author preetam
 */
public class RateLimiterTest {


    private RateLimiter rateLimiter;

    @BeforeMethod (alwaysRun = true)
    public void init(){
        rateLimiter = RateLimiter.valueOf(500);
        runTimer();
    }

    private static ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

    public void runTimer(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("****Interval of 1 Second****");
            }
        };
        exec.scheduleAtFixedRate(r,0,1,TimeUnit.SECONDS);
    }

    public void shutdown(){
        if(!exec.isShutdown()){
            exec.shutdown();
        }
    }

    void sendDummyData(byte[] packets) {
        rateLimiter.acquire(packets.length); //This is a blocking call
        //Do Something once the permits are acquired.
        System.out.println("LENGTH: "+packets.length+ " "+ Thread.currentThread().getName());

    }

    @Test
    public void testLimiter() throws InterruptedException {

        Callable<Boolean> r = new Callable<Boolean>() {
            public Boolean call() {
                final byte[] bytes = new byte[100];
                Arrays.fill(bytes, Byte.valueOf("01",2));
                sendDummyData(bytes);
                return true;
            }
        };
        final ExecutorService execService = Executors.newFixedThreadPool(6);
        final List<Callable<Boolean>> callables = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            callables.add(r);
        }
        execService.invokeAll(callables);
        Thread.sleep(5000);
        execService.invokeAll(callables);
        shutdown();
    }
}
