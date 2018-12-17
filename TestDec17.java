package com.test;


public class TestDec17 {

    Object hello = new Object();
    Object world = new Object();


    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<1;i++){
            Runnable printHello = new Runnable(){
                @Override
                public void run(){
                    new TestDec17().printHello();
                }
            };

            Runnable printWorld = new Runnable(){
                @Override
                public void run(){
                    new TestDec17().printWorld();
                }
            };

            Thread t1 = new Thread(printHello);
            Thread t2 = new Thread(printWorld);
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }

    }

    public void printHello(){
        synchronized (hello) {
            System.out.print("Hello, ");
        }
    }

    public void printWorld(){
        synchronized (world) {
            System.out.println("World");
        }
    }
}
