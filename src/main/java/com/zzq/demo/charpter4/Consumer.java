package com.zzq.demo.charpter4;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 332406 on 2017-12-05.
 */
public class Consumer implements Runnable {
    private final BlockingQueue queue;
    private static int count = 0;
    private static long startTime;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void consume(Object e) {
//        System.out.println("消费一个元素，值为：" + e.toString());
        count++;
    }

    public void run() {
        startTime = System.currentTimeMillis();
        try {
            while (true) {
                consume(queue.take());
//                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getConsumeNumber() {
        long spendTime = System.currentTimeMillis() - startTime;
        System.out.println("一共消费了 " + count + " 个元素，耗时："+spendTime+"ms");
    }
}
