package lr1;

import java.util.concurrent.ThreadLocalRandom;

public class MutexThread implements Runnable
{
	CommonResource res;
	MutexThread(CommonResource res){
        this.res=res;
    }
	
    public void run(){
    	int randomNum;

    	synchronized(res){
    		res.x=1;
	        for (int i = 1; i < 5; i++){
	            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
	            res.x++;
	            try{
	            	randomNum = ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
	                Thread.sleep(randomNum);
	            }
	            catch(InterruptedException e){}
	        }
    	}
    }
}
