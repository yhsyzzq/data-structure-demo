package com.zzq.demo.charpter4_bak;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yhsyzzq on 2017-12-05.
 */
public class QueueTest {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1000);
        final Producer producer = new Producer(queue);
        final Consumer consumer = new Consumer(queue);

        Thread produceThread = new Thread(producer);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Thread monitorThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    Producer.getProduceNumber();
                    Consumer.getConsumeNumber();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        monitorThread.start();

        produceThread.start();

        while (true) {
            executorService.execute(consumer);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
