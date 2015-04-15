package p10_Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 这个工具主要是每个任务有多个阶段，
 * 如第三个阶段开始的前提必须是第二个阶段的所有人完成了任务。
 * 可以向CyclicBarrier 其中注入runnable对象，这样计数器到达0时候自动触发该事件，同时计数值重置。
 * @类功能说明:   
 * @公司名称     :中企动力
 * @作者                ：Administrator 
 * @创建时间      ：2014年12月15日 上午10:00:25  
 * @版本                ：V1.0
 */
public class CyclicBarrierTest {
	
	
	private final static CyclicBarrier cyclicBarrier = new CyclicBarrier(10,new Runnable() {
		public void run() {
			System.out.println("新的任务开始啦");
		}
	});
	
	public static void main(String[] args) throws InterruptedException {
		for(int i= 0; i<10;i++){
			new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() +"--> begin run");
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BrokenBarrierException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() +"--> begin jump"+cyclicBarrier.getNumberWaiting());
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BrokenBarrierException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() +"--> begin walk");
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BrokenBarrierException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"--> end");
				}
			},String.valueOf(i)).start();
		}
		
		
		
	}

}
