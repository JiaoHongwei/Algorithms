package com.hw.chapter_2;

import java.util.concurrent.CountDownLatch;

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

        for (int i = 0; i < THREAD_NUM; i++) {

            new Thread() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread() + " 运行..." + System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            countDownLatch.countDown();
        }
        System.out.println("for结束...");

    }
}
