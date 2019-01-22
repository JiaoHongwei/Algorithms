package com.hw.chapter_2;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/22 15:40
 * @Version 1.0
 */
public class NotifyDemo {
    static Object object = new Object();

    static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start! ");
                try {
                    System.out.println(System.currentTimeMillis()
                            + ":T1 wait for object ");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {

            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end!");
                try {
                    Thread.sleep(2000);
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 不能使用 junit 框架来运行
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        // 保证 t1 先执行
        Thread.sleep(1000);
        t2.start();
    }
}
