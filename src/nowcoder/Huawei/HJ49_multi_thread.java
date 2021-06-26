package nowcoder.Huawei;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HJ49_multi_thread {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyPrinter myprinter = new MyPrinter();
        ExecutorService threadpool = Executors.newFixedThreadPool(4);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            CountDownLatch cdl = new CountDownLatch(4);
            threadpool.execute(new Runnable(){
                @Override
                public void run(){
                    try{
                        for(int i = 0; i < num; i++){
                            myprinter.printA();
                        }
                    }
                    finally{
                        cdl.countDown();
                    }
                }
            });

            threadpool.execute(new Runnable(){
                @Override
                public void run(){
                    try{
                        for(int i = 0; i < num; i++){
                            myprinter.printB();
                        }
                    }
                    finally{
                        cdl.countDown();
                    }
                }
            });

            threadpool.execute(new Runnable(){
                @Override
                public void run(){
                    try{
                        for(int i = 0; i < num; i++){
                            myprinter.printC();
                        }
                    }
                    finally{
                        cdl.countDown();
                    }
                }
            });

            threadpool.execute(new Runnable(){
                @Override
                public void run(){
                    try{
                        for(int i = 0; i < num; i++){
                            myprinter.printD();
                        }
                    }
                    finally{
                        cdl.countDown();
                    }
                }
            });

            try{
                cdl.await();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println();
        }
        //一定要关闭线程池；一定要关闭线程池；一定要关闭线程池；一定要关闭线程池；一定要关闭线程池；
        threadpool.shutdown();
    }
}

class MyPrinter{
    Lock lock = new ReentrantLock();
    Condition cd1 = lock.newCondition();
    Condition cd2 = lock.newCondition();
    Condition cd3 = lock.newCondition();
    Condition cd4 = lock.newCondition();
    int flag = 1;

    void printA(){
        try{
            lock.lock();
            if(flag!=1){
                cd1.await();
            }
            System.out.print("A");
            flag =2;
            cd2.signal();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    void printB(){
        try{
            lock.lock();
            if(flag!=2){
                cd2.await();
            }
            System.out.print("B");
            flag = 3;
            cd3.signal();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    void printC(){
        try{
            lock.lock();
            if(flag!=3){
                cd3.await();
            }
            System.out.print("C");
            flag = 4;
            cd4.signal();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    void printD(){
        try{
            lock.lock();
            if(flag!=4){
                cd4.await();
            }
            System.out.print("D");
            flag = 1;
            cd1.signal();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }
}
