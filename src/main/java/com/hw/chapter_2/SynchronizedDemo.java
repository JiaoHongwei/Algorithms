package com.hw.chapter_2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/18 11:38
 * @Version 1.0
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

    }

    synchronized public void test() {
        System.out.println("同步方法...");
    }

    synchronized public static void demo() {
        System.out.println("同步静态方法...");
    }

    public void version() {
        synchronized (this) {
            System.out.println("同步块...");
        }
        String a = "asas";
        synchronized (a) {
            System.out.println("同步string");
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        reentrantLock.tryLock();

        Lock lock = new ReentrantLock();

    }
}
