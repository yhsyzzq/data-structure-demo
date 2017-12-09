package com.zzq.demo.charpter4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by yhsyzzq on 2017-12-05.
 */
public class QueueTest {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10000);
        final Producer producer = new Producer(queue);
        final Consumer consumer = new Consumer(queue);

        Thread produceThread = new Thread(producer);
        Thread consumeThread1 = new Thread(consumer);
        Thread consumeThread2 = new Thread(consumer);
        Thread consumeThread3 = new Thread(consumer);
        Thread consumeThread4 = new Thread(consumer);
        produceThread.start();
        consumeThread1.start();
        consumeThread2.start();
        consumeThread3.start();
        consumeThread4.start();

        Thread monitorThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    producer.getProduceNumber();
                    consumer.getConsumeNumber();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        monitorThread.start();

    }
}
