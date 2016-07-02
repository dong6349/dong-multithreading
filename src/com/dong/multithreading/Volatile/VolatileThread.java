package com.dong.multithreading.Volatile;

/**
 * Created by dongy on 2016/7/2.
 */
public class VolatileThread {
    /**
     *  ���һ����������volatile�ؼ��֣��ͻ���߱�������JVM���ڴ�ģ�ͣ�
     *  ��������������̹߳���ġ��ɼ��ģ�ÿ��JVM�����ȡ����д���ֵ��
     *  ʹ������ֵ������CPU�ɼ���
     *  volatile�ƺ���ʱ���������򵥵������ƺ�����volatile�ؼ��־�ʡ��������
     *  volatile�ܱ�֤�ñ����������̵߳Ŀɼ��ԣ����ǲ��ܱ�֤ԭ���ԡ�
     *
     *  volatile���õĳ����ǣ�setandget  ����getandoperate
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
