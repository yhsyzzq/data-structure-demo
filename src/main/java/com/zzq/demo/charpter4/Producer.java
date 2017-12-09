package com.zzq.demo.charpter4;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by yhsyzzq on 2017-12-05.
 */
public class Producer implements Runnable {
    private final BlockingQueue queue;
    private static int count = 0;
    private static long startTime;
    private static long endTime;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public int produce() {
        int e = new Random().nextInt(10);
//        System.out.println("生产了一个元素，值为：" + e);
        count++;
        return e;
    }

    public void run() {
        startTime = System.currentTimeMillis();
        try {
            while (true) {
                queue.put(produce());
//                    Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getProduceNumber() {
        long spendTime = System.currentTimeMillis() - startTime;
        System.out.println("一共生产了 " + count + " 个元素，耗时："+spendTime+"ms");
    }
}
