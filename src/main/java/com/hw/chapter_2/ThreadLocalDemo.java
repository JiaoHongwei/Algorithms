package com.hw.chapter_2;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/23 18:08
 * @Version 1.0
 */
public class ThreadLocalDemo {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();


    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.set();
        System.out.println(threadLocalDemo.getLong());
        System.out.println(threadLocalDemo.getString());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalDemo.set();
                System.out.println(threadLocalDemo.getLong());
                System.out.println(threadLocalDemo.getString());
            }
        });

        thread.start();
        thread.join();
        System.out.println(threadLocalDemo.getLong());
        System.out.println(threadLocalDemo.getString());

    }

}
