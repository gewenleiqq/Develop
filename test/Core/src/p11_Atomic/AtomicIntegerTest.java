package p11_Atomic;

import java.util.concurrent.atomic.AtomicInteger;
/**
 */
public class AtomicIntegerTest {
	public static void main(String[] args) throws InterruptedException {
		
		AtomicInteger ai=new AtomicInteger(2);
		ai.addAndGet(1);
		
		boolean a = ai.compareAndSet(2, 4);
	 
		System.out.println(ai+"--"+a);
		boolean a2=ai.weakCompareAndSet(3, 45);//
		System.out.println(ai+"--"+a2);
	}
	
}
