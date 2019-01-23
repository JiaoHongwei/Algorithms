package com.hw.chapter_2;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/22 16:42
 * @Version 1.0
 */
public class OrderDemo {

    int a = 0;
    boolean flag = false;

    public void write() {
        a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            int i = a + 1;
        }
    }
}