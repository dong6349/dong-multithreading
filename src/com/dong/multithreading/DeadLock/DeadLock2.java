package com.dong.multithreading.DeadLock;

/**
 * Created by john on 2016/6/30.
 */
public class DeadLock2 {

    public static Object lock = new Object();

    public static void main(String[] args){
        Thread thread1 = new Thread(new WorkThread());
        Thread thread2 = new Thread(new WorkThread());
        thread1.start();
        thread2.start();
    }
}

class WorkThread extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " try to lock the lock.");
        synchronized(DeadLock2.lock){
            while(true){
                System.out.println(Thread.currentThread().getName() + " get the lock. But he don't stop, hhh!'");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}