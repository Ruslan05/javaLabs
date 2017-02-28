package lr1;

import java.util.ArrayList;

public class Mutex 
{
	public static void RunExampe()
	{
		CommonResource commonResource = new CommonResource();
		int tCount = 5;
		ArrayList<Thread> tList = new ArrayList<Thread>();
		
        for (int i = 0; i < tCount; i++){
        	tList.add(new Thread(new MutexThread(commonResource)));
        	tList.get(i).setName("Поток "+ i);
        	tList.get(i).start();
        	try {
				tList.get(i).join();
				System.out.println("Завершен: " + tList.get(i).getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
}
