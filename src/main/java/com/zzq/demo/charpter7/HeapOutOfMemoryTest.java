package com.zzq.demo.charpter7;

import java.util.Vector;

/**
 * Created by yhsyzzq on 2017-12-19.
 */
public class HeapOutOfMemoryTest {

    public static void main(String[] args) throws InterruptedException {
        while(true){

            Vector<Object> vector = new Vector<Object>();
            for(int i=0;i<10000;i++){
                Object o = new Object();
                vector.add(o);
            }
            System.out.println("打印。。。");
            Thread.sleep(10000);
        }

    }
}
