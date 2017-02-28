package lr1.Pull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import lr1.CommonResource;

public class PullExample {
	
	public void RunExample(){
		CommonResource res = new CommonResource();
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++) {
		 service.execute(new Runnable() {
			public void run() {
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
		    	service.shutdown();
			}
		 });
		}
	}
}
