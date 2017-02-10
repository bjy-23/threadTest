package com.example.bjy.threadtest.test2;

import android.util.Log;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by bjy on 2017/2/10.
 */

public class Data2 {
    private int data;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public void set(int data) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入数据");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public synchronized void get() {
        readWriteLock.readLock().lock();
        try{
//            System.out.println(Thread.currentThread().getName() + "准备读取数据");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "读取" + this.data);

            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime <1){
                System.out.println(Thread.currentThread().getName() +"读取数据");
            }
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
