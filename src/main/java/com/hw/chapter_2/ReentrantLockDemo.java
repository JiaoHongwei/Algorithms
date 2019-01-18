package com.hw.chapter_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/18 16:22
 * @Version 1.0
 */
public class ReentrantLockDemo {
    private static List<Integer> list = new ArrayList<Integer>();
    // 声明为全局的
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final ReentrantLockDemo test = new ReentrantLockDemo();
        new Thread() {
            @Override
            public void run() {
                test.insert2(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.insert2(Thread.currentThread());
            }
        }.start();
        Thread.yield();

    }

    private void insert(Thread currentThread) {
        lock.lock();
        try {
            System.out.println(currentThread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                list.add(i);
            }

        } catch (Exception e) {

        } finally {
            System.out.println(currentThread.getName() + "释放了锁");
            System.out.println(list);
            lock.unlock();

        }
    }

    private void insert2(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "获取锁成功");
                for (int i = 0; i < 100; i++) {
                    list.add(i);
                }
            } catch (Exception e) {

            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }

        } else {
            System.out.println(thread.getName() + "获取锁失败");
        }
    }
}
