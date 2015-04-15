package p08_Thread.Exception;

import java.util.Random;

public class MyThreadGroupTest extends ThreadGroup {
	public MyThreadGroupTest(String name) {
		super(name);
	}
	
	 
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has thrown an Exception\n",t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();
	}

/**
 *	当运行这个例子，你会发现线程对象是如何抛出异常和其他被中断的。当一个非捕捉异常在线程内抛出，JVM会为这个异常寻找3种可能handlers。
	首先, 它寻找这个未捕捉的线程对象的异常handle，如在线程中处理不受控制异常中介绍的，
	如果这个handle 不存在，那么JVM会在线程对象的ThreadGroup里寻找非捕捉异常的handler，如我们在这个指南中学习的。
	如果此方法不存在，那么 JVM 会寻找默认非捕捉异常handle。
	如果没有 handlers存在, 那么 JVM会把异常的 stack trace 写入控制台并结束任务。
 * @param args
 */
	public static void main(String args[]){
		MyThreadGroupTest threadGroup=new MyThreadGroupTest("MyThreadGroup111");
		Thread t=new Thread(threadGroup, new	ExceptionGroupThread());
		t.start();
	}
}

class ExceptionGroupThread implements Runnable{
	@Override
	public void run() {
		int result;
		Random random=new Random(Thread.currentThread().getId());
		while (true) {
			result=1000/((int)(random.nextDouble()*1000));
			System.out.printf("%s : f\n",Thread.currentThread().getId(),result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("111%d : Interrupted\n",Thread.currentThread().getId());
				return;
			}	
		}
	}
}