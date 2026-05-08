package com.jsp;

public class Threads1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        T1 t  = new T1();



        t.setName("thread hai ye");
        t.start();
        t.join(6000);


        System.out.println("Main End");
    }
}

class T1 extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
//        try {
//           // Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for(int i=0;i<=10;i++){
            System.out.println(i);
        }
    }
}
