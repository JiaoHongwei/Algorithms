package com.hw.chapter_2;

/**
 * @Description 双重锁单例模式
 * @Author hw
 * @Date 2019/1/10 16:27
 * @Version 1.0
 */
public class SingleTon {
    private static volatile SingleTon singleTon;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
