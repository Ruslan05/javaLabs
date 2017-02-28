package lr1.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCommonResource {
	AtomicInteger c = new AtomicInteger(0);
	
    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public void set(int newValue) {
        c.set(newValue);
    }
    
    public int value() {
        return c.get();
    }
}
