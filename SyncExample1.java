
package com.jsp;

public class SyncExample {
    public static void main(String[] args)throws InterruptedException {

        Counter c = new Counter();
        T3 t = new T3(c);
        Thread thread1 = new Thread(t);
        thread1.start();

        T3 t1 = new T3(c);
        Thread thread2 = new Thread(t1);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(c.getCount());

    }
}

class T3 implements Runnable{
    Counter c;
    public T3(Counter c){
        this.c = c;

    }
    @Override
    public void run(){
        for(int i=1;i<=100;i++){
            c.inc();
        }
    }
}


public class Counter {
    private int count;

    public synchronized void inc(){
        count++;
    }
    public int getCount(){
        return count;
    }

}








