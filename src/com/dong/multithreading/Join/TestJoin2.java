package com.dong.multithreading.Join;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuxin on 2016/7/1.
 */
public class TestJoin2 {

    public static int tj2 = 0;

    public static void main(String[] args){
        Thread thread = new Thread(new JoinThread2());
        try{
            thread.start();
            thread.join(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(tj2);
    }
}

class JoinThread2 implements Runnable{

    @Override
    public void run(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 5; i++){
            TestJoin2.tj2++;
        }

    }
}
