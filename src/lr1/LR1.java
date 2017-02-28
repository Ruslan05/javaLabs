package lr1;

import lr1.Atomic.AtomicExample;
import lr1.Mutex.Mutex;
import lr1.Pull.PullExample;
import lr1.Semaphore.SemaphoreExample;

public class LR1 
{
    public static void main(String[] args) {
//    	Mutex.RunExampe();
//    	SemaphoreExample.RunExample();
//    	AtomicExample.RunExample();
    	PullExample pull = new PullExample();
    	pull.RunExample();
    }
}
 

 
