package p08_Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		//创建一个可重用固定线程集合的线程池，以共享的无界队列方式来运行这些线程。
		// 创建可以容纳3个线程的线程池  
		ExecutorService threadPool1 = Executors.newFixedThreadPool(3);
		
		//创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
		//线程池的大小会根据执行的任务数动态分配 
		ExecutorService threadPool2 = Executors.newCachedThreadPool(); 
		
		//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		//创建单个线程的线程池，如果当前线程在执行任务时突然中断，则会创建一个新的线程替代它继续执行任务
		ExecutorService threadPool3 = Executors.newSingleThreadExecutor();
		
		//创建一个可安排在给定延迟后运行命令或者定期地执行的线程池。
		// 效果类似于Timer定时器
		ScheduledExecutorService threadPool4 = Executors.newScheduledThreadPool(3); 
		
		
		//创建了一个固定大小的线程池，容量为3，然后循环执行了4个任务，由输出结果可以看到，前3个任务首先执行完，
		//然后空闲下来的线程去执行第4个任务，在FixedThreadPool中，有一个固定大小的池，如果当前需要执行的任务超过了池大小，
		//那么多于的任务等待状态，直到有空闲下来的线程执行任务，而当执行的任务小于池大小，空闲的线程也不会去销毁。
		ExecutorService threadPool = Executors.newFixedThreadPool(3);  
		
		
		
		//CachedThreadPool会创建一个缓存区，将初始化的线程缓存起来，如果线程有可用的，就使用之前创建好的线程，
		//如果没有可用的，就新创建线程，终止并且从缓存中移除已有60秒未被使用的线程。
		Executors.newCachedThreadPool();
		
		
	}
}
 