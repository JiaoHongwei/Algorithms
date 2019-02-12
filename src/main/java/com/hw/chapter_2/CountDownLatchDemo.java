package com.hw.chapter_2;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/21 15:14
 * @Version 1.0
 */
public class CountDownLatchDemo {

    private static final int THREAD_NUM = 10;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(
                THREAD_NUM,
                THREAD_NUM, 0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), r -> new Thread(r, "hw"), new ThreadPoolExecutor.AbortPolicy());
//        new ThreadPoolExecutor.DiscardPolicy();
//        new ThreadPoolExecutor.AbortPolicy();
//        new ThreadPoolExecutor.CallerRunsPolicy();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < THREAD_NUM; i++) {
            executorService.execute(() -> {
                try {
                    countDownLatch.await();
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() + "... 执行..." + " " + Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }

        System.out.println("for结束...");
        executorService.shutdown();

    }
}
