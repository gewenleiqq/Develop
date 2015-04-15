package p08_Thread.CountDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	final static int workSize=100;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CountDownLatch latch=new CountDownLatch(workSize);//需要多少工人
		for(int i=0;i<workSize;i++){
			int workTime=new Random().nextInt(100000);//每个工人完成工作需要的时间
			Worker worker=new Worker(i,workTime, latch);
			worker.start();
		}
    	latch.await();//等待所有工人完成工作
        System.out.println("all work done at "+sdf.format(new Date()));
	}
    static class Worker extends Thread{
    	int workTime;
    	int workerId;
    	CountDownLatch latch;
    	public Worker(int workerId,int workTime  ,CountDownLatch latch){
    		 this.workTime=workTime;
    		 this.latch=latch;
    		 this.workerId=workerId;
    	}
    	public void run(){
    		try {
    			System.out.println("Worker "+workerId+" do work begin at "+sdf.format(new Date()));
        		doWork();//工作了
        		System.out.println("Worker "+workerId+" do work complete at "+sdf.format(new Date()));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				latch.countDown();//工人完成工作，计数器减一
			}
    		
    	}
    	
    	private void doWork(){
    		try {
				Thread.sleep(workTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}
