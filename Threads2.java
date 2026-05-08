package com.jsp;

public class Threads2 {
    public static void main(String[] args) {

        System.out.println("main start");
        T2 th = new T2();
       Thread t = new Thread(th) ;
       t.start();
       System.out.println("main end");
    }
}

class T2 implements Runnable{

    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<=10;i++){
            System.out.println(i);
        }

    }
}
