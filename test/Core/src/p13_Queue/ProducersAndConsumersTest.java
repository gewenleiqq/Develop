package p13_Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducersAndConsumersTest {
	public static volatile BlockingQueue<String> bq=new ArrayBlockingQueue<String>(55);
	public static void main(String[] args) {
		ProducersAndConsumersTest bqt=new ProducersAndConsumersTest();
		new Thread(bqt.createAdd()).start();  
		new Thread(bqt.createRead()).start();  
	}
	private AddThreadTest createAdd(){
		AddThreadTest ss =new AddThreadTest();
		return ss;
	}
	private ReadThreadTest createRead(){
		ReadThreadTest ss =new ReadThreadTest();
		return ss;
	}
	class AddThreadTest implements Runnable{
		private String threadName;
		public AddThreadTest(){
			this.setThreadName(java.util.UUID.randomUUID().toString());
		}
		public void run() { 
			while(true){
				try {
					Thread ct = Thread.currentThread();
					System.out.println("add线程0："+ct.getName()+" ,"+bq.size());
					bq.put(java.util.UUID.randomUUID().toString());
//					bq.offer(java.util.UUID.randomUUID().toString());
					System.out.println("add线程1："+ct.getName()+" ,"+bq.size());
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        	
        }
		public String getThreadName() {
			return threadName;
		}
		public void setThreadName(String threadName) {
			this.threadName = threadName;
		}  
		
	}
	class ReadThreadTest implements Runnable{
		private String threadName;
		public ReadThreadTest(){
			this.setThreadName(java.util.UUID.randomUUID().toString());
		}
		public void run() { 
			while(true){
				try {
					Thread ct = Thread.currentThread();
					System.out.println("read线程1："+ct.getName()+" ,"+bq.size());
					bq.take();
					//bq.poll(); 
					System.out.println("read线程2："+ct.getName()+" ,"+bq.size());
//					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        }
		public String getThreadName() {
			return threadName;
		}
		public void setThreadName(String threadName) {
			this.threadName = threadName;
		}  
		
	}
	 
}
