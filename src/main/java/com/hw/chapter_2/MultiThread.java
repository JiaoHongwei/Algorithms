package com.hw.chapter_2;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/15 14:56
 * @Version 1.0
 */
public class MultiThread {

    public static void main(String[] args) throws Exception {

        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newCachedThreadPool();
        ExecutorService executor3 = Executors.newFixedThreadPool(5);
        ExecutorService executor4 = Executors.newScheduledThreadPool(5);

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public java.lang.Thread newThread(Runnable r) {
                return new java.lang.Thread("jiaohongwei");
            }
        };
        ExecutorService service = new ThreadPoolExecutor(0, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1), factory);
        service.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        service.shutdown();
        service.shutdownNow();


//        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);


        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("开始执行子线程" + Thread.currentThread());
                Thread.sleep(10000);
                return 8;
            }
        });
        new Thread(task).start();
        System.out.println("子线程返回值：" + task.get());
        System.out.println("执行结束");



        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Callable:"+ Thread.currentThread());
                Thread.sleep(10000);
                Thread.yield();
                return 8;
            }
        };
        System.out.println("callable......");
        Integer call = callable.call();
        System.out.println("callable:" + call);


        Thread thread = Thread.currentThread();
        thread.isAlive();

        thread.join();
        Thread.sleep(500);
        Thread.interrupted();
        thread.interrupt();
        thread.isAlive();
        Thread.yield();
        thread.join();
    }
}
