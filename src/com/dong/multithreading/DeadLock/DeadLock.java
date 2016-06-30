package com.dong.multithreading.DeadLock;

/**
 * Created by john on 2016/6/30.
 */
public class DeadLock {

    public static Object lock1 = new Object();

    public static Object lock2 = new Object();

    public static void main(String[] args){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " try to lock the lock1.");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + ", I get the lock1");
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " try to lock the lock2");
                        synchronized (lock2){
                            System.out.println(Thread.currentThread().getName() + " get the lock2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " try to lock the lock2.");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + ", I get the lock2");
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " try to lock the lock1");
                        synchronized (lock1){
                            System.out.println(Thread.currentThread().getName() + " get the lock1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}

