package com.hw.chapter_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/18 17:31
 * @Version 1.0
 */
public class JUCDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> map = new HashMap<String, Object>();

        Map<String, Object> map1 = new ConcurrentHashMap<String, Object>();

        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        copyOnWriteArrayList.add("aaa");
        copyOnWriteArrayList.get(1);

        ConcurrentSkipListMap<String, Object> concurrentSkipListMap = new ConcurrentSkipListMap<String, Object>();
        concurrentSkipListMap.put("aaa", map);

        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.add("asas");

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
        try {
            linkedBlockingQueue.put("string");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);
        arrayBlockingQueue.put("asas");
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<String>();

        Set<String> set = new CopyOnWriteArraySet<String>();
        AtomicInteger atomicInteger = new AtomicInteger();


    }


}
