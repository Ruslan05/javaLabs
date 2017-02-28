package lr1.Semaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import lr1.CommonResource;

public class SemaphoreExample {

	public static void RunExample() {
		CommonResource commonResource = new CommonResource();
		Semaphore sem = new Semaphore(1);
		int tCount = 5;
		ArrayList<Thread> tList = new ArrayList<Thread>();
		
	    for (int i = 0; i < tCount; i++){
	    	tList.add(new Thread(new SemaphoreThread(commonResource, sem, "SemaphoreThread" + i)));
	    	tList.get(i).setName("Поток "+ i);
	    	tList.get(i).start();
	    }
	}
}
