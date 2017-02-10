package com.example.bjy.threadtest.test1;

import android.util.Log;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bjy on 2017/2/9.
 */

public class Thread1 extends Thread{
    private static int count = 0, x = 0,y = 100;
    private Condition condition;
    private Lock lock = new ReentrantLock();

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        lock.lock();
        condition = lock.newCondition();
        Random random = new Random();
        int a =   random.nextInt();
        int b = a%2;
        if (b==0){
            count++;
            Log.e(Thread.currentThread().getName(),"偶数     "+ count);
            if(x<10){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            x-=10;
            y+=10;

            Log.e(Thread.currentThread().getName()+": "+x,""+y);
            condition.signalAll();
        }else {
            count++;
            Log.e(Thread.currentThread().getName(),"奇数     "+ count);
            if (y<10){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            x+=10;
            y-=10;
            Log.e(Thread.currentThread().getName()+": "+x,""+y);
            condition.signalAll();
        }

        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
