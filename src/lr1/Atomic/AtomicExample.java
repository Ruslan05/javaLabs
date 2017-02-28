package lr1.Atomic;

import java.util.ArrayList;

public class AtomicExample {
	public static void RunExample()
	{
		AtomicCommonResource commonResource = new AtomicCommonResource();
		int tCount = 5;
		ArrayList<Thread> tList = new ArrayList<Thread>();
		
        for (int i = 0; i < tCount; i++){
        	tList.add(new Thread(new AtomicThread(commonResource)));
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
