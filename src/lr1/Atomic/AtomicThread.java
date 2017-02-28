package lr1.Atomic;

import java.util.concurrent.ThreadLocalRandom;

public class AtomicThread implements Runnable
{
	AtomicCommonResource res;
	AtomicThread(AtomicCommonResource res){
        this.res=res;
    }
	
    public void run(){
    	int randomNum;

		res.set(1);
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.value());
            res.increment();
            try{
            	randomNum = ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
                Thread.sleep(randomNum);
            }
            catch(InterruptedException e){}
        }
    }
}
