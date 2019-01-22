package com.hw.chapter_2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/22 11:46
 * @Version 1.0
 */
public class CyclicBarrierDemo implements Runnable {

    private static final int THREAD_NUM = 3;
    // barrier action 在屏障执行时执行
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_NUM, this);
    private ExecutorService service = new ThreadPoolExecutor(THREAD_NUM, THREAD_NUM, 0L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(THREAD_NUM),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "cyclicBarrier");
                }
            },
            new ThreadPoolExecutor.CallerRunsPolicy());
    // 保证每个学生的平均成绩
    private Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();


    public void count() {
        for (int i = 0; i < THREAD_NUM; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //计算每个学生的平均成绩,代码略()假设为60~100的随机数
                    int score = (int) (Math.random() * 40 + 60);
                    map.put(Thread.currentThread().getName(), score);
                    //执行完运行await(),等待所有学生平均成绩都计算完毕
                    try {
                        cyclicBarrier.await();   //全部阻塞在这里，直到循环到最后一次，所有线程到达屏障，但是要先执行主线程.
                        System.out.println(Thread.currentThread().getName() + "同学的平均成绩为" + score);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + "   " + map.get(s));
            result += map.get(s);
        }
        System.out.println("三人平均成绩为:" + (result / 3) + "分");
    }


    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        cyclicBarrierDemo.count();
    }
}
