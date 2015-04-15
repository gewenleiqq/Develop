package p10_Concurrent;


import java.util.concurrent.CountDownLatch;

/**
 *   这个工具主要是将一个任务分解，等待所有的子任务完成才会做下面的操作，
 *   这个等待的操作主要是await控制的。计数值不能被重置，需要重置的情况需要使用CyclicBarrier。
 *   下面的例子发现所有的线程都执行完成，才会打印done。
 *   如果注释掉latch.await();  发现done是在中间打印的，没有等待子任务都完成就执行了。
 * @类功能说明:   
 * @公司名称     :中企动力
 * @作者                ：Administrator 
 * @创建时间      ：2014年12月15日 上午9:59:09  
 * @版本                ：V1.0
 */
public class CountDownLatchTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		final CountDownLatch latch = new CountDownLatch(10);
		for(int i= 0; i<10;i++){
			new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() +"--> begin");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"--> end");
					latch.countDown();
				}
			},String.valueOf(i)).start();
		}
		
		latch.await();
		System.out.println("done------------");
		
	}

}
