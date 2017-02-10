package com.example.bjy.threadtest.test2;

/**
 * Created by bjy on 2017/2/9.
 */

public class Data {
    private int data;

    public synchronized void set(int data) {
        System.out.println(Thread.currentThread().getName() + "准备写入数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);
    }

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName() + "准备读取数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);
    }
}
