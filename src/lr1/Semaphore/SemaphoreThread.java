package lr1.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

import lr1.CommonResource;

public class SemaphoreThread implements Runnable{

    CommonResource res;
    Semaphore sem;
    String name;
    SemaphoreThread(CommonResource res, Semaphore sem, String name){
        this.res=res;
        this.sem=sem;
        this.name=name;
    }
      
    public void run(){
    	int randomNum;
        try{
            System.out.println(name + " ожидает разрешение");
            sem.acquire();
            res.x=1;
            for (int i = 0; i < 5; i++){
            	randomNum = ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
                System.out.println(this.name + ": " + res.x);
                res.x++;
                Thread.sleep(randomNum);
            }
        }
        catch(InterruptedException e){System.out.println(e.getMessage());}
        System.out.println(name + " освобождает разрешение");
        sem.release();
    }	
}
