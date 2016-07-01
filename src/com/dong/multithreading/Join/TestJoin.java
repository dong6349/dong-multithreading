package com.dong.multithreading.Join;

/**
 * Created by yuxin on 2016/7/1.
 */
public class TestJoin {

    public static int i = 0;

    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            Thread thread = new Thread(new JoinThread());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(i);
    }
}

class JoinThread extends Thread{

    @Override
    public void run(){
        for(int j = 0; j < 5; j++){
            System.out.println("aaa");
        }
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        TestJoin.i++;
        System.out.println("The thread name is " + Thread.currentThread().getName() + ", and the i is " + TestJoin.i);
    }
}