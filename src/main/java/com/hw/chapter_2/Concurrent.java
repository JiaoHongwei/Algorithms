package com.hw.chapter_2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/11 17:31
 * @Version 1.0
 */
public class Concurrent {
    @Test
    public void concurrentHashMap() {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>(2);
        map.put("111", 1111);
        map.put("222", 2222);
        map.put("333", 3333);
        for (int i = 0; ; ) {
            map.put(i + "", i++);
            System.out.println(i);
        }

    }
}
