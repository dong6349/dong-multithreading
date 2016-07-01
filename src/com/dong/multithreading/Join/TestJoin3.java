package com.dong.multithreading.Join;

/**
 * Created by yuxin on 2016/7/1.
 */
public class TestJoin3 {

    public static void main(String[] args){

        System.out.println(Thread.currentThread().getName() + " start.");

        Join3Thread1 join3Thread1 = new Join3Thread1();
        Join3Thread2 join3Thread2 = new Join3Thread2(join3Thread1);

        join3Thread1.start();
        try {
            Thread.sleep(2000);
            join3Thread2.start();
            join3Thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " end.");

    }
}

class Join3Thread1 extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " start.");
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + " is looping. The value is "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " end.");
    }
}

class Join3Thread2 extends Thread{

    Join3Thread1 join3Thread1;

    public Join3Thread2(Join3Thread1 join3Thread1){
        this.join3Thread1 = join3Thread1;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " started.");
        try {
            join3Thread1.join();
            System.out.println(Thread.currentThread().getName() + " end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
