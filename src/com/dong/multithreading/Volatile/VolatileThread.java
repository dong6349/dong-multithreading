package com.dong.multithreading.Volatile;

/**
 * Created by dongy on 2016/7/2.
 */
public class VolatileThread {
    /**
     *  如果一个变量加了volatile关键字，就会告诉编译器和JVM的内存模型：
     *  这个变量对所有线程共享的、可见的；每次JVM都会读取最新写入的值并
     *  使其最新值在所有CPU可见。
     *  volatile似乎有时候可以替代简单的锁，似乎加了volatile关键字就省掉了锁。
     *  volatile能保证该变量对所有线程的可见性，但是不能保证原子性。
     *
     *  volatile适用的场景是，setandget  不是getandoperate
     */

    private static volatile long _longVal = 0;

    private static class LoopVolatile implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                _longVal++;
                val++;
            }
        }
    }

    private static class LoopVolatile2 implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                _longVal++;
                val++;
            }
        }
    }

    private  void testVolatile(){
        Thread t1 = new Thread(new LoopVolatile());
        t1.start();

        Thread t2 = new Thread(new LoopVolatile2());
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }

        System.out.println("final val is: " + _longVal);
    }

    public static void main(String[] args){
        VolatileThread volatileThread = new VolatileThread();
        volatileThread.testVolatile();
    }


}
