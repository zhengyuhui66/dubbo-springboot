package com.xiaoze.consumer;

public class CPUTest {

    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    i++;
                    if(i>100000){
                        i=0;
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    i++;
                    if(i>100000){
                        i=0;
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    i++;
                    if(i>100000){
                        i=0;
                    }
                }
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    i++;
                    if(i>100000){
                        i=0;
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
