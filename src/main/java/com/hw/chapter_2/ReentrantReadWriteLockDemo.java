package com.hw.chapter_2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/18 17:01
 * @Version 1.0
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrantReadWriteLockDemo test = new ReentrantReadWriteLockDemo();
        new Thread() {
            @Override
            public void run() {
                test.get2(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.get2(Thread.currentThread());
            }
        }.start();
    }

    /**
     * synchronized
     *
     * @param thread
     */
    private synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName() + "正在进行读操作");
        }
        System.out.println(thread.getName() + "读操作完毕");
    }

    /**
     * 使用 ReentrantReadWriteLock 读写锁
     * @param thread
     */
    private void get2(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        }finally {
            rwl.readLock().unlock();
        }
    }


}
