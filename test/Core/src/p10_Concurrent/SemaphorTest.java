package p10_Concurrent;

import java.util.concurrent.Semaphore;
/**
 * 计数器的价值在于控制只能有n个子任务访问某个资源。如下面的例子，只能同时存在三个进程。
 * @类功能说明:   
 * @公司名称     :中企动力
 * @作者                ：Administrator 
 * @创建时间      ：2014年12月15日 上午10:00:01  
 * @版本                ：V1.0
 */
public class SemaphorTest {
	
	static Semaphore semaphore = new Semaphore(3, true);
	
	public static void main(String[] args) {
		for(int i= 0; i<10;i++){
			new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() +"--> begin ");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"--> end");
					semaphore.release();
				}
			},String.valueOf(i)).start();
		}
	}

}
