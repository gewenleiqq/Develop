package p13_Queue;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * 继承queue的接口有：
 * 	BlockingDeque<E>, 
 * 	BlockingQueue<E>,
 *	Deque<E>, 
 *	TransferQueue<E> 
 * 
 * ------ ----------------------------------------------
 * 具体实现类有：
 *	AbstractQueue, 
 *	ArrayBlockingQueue, 
 *	ArrayDeque, 
 *	ConcurrentLinkedDeque, 
 *	ConcurrentLinkedQueue, 
 *	DelayQueue, 
 *	LinkedBlockingDeque,
 * 	LinkedBlockingQueue, 
 * 	LinkedList, 
 *	LinkedTransferQueue, 
 *	PriorityBlockingQueue,
 * 	PriorityQueue, 
 * 	SynchronousQueue 
 * 
 */
public class ArrayBlockingQueueTest {
	public static volatile ArrayBlockingQueue<Integer> bq=new ArrayBlockingQueue<Integer>(55);
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		
		Integer z=3;
		System.out.println("-"+Integer.toBinaryString(z));
		z=z>>> 5;
		System.err.println("+"+Integer.toBinaryString(z));
		ArrayBlockingQueueTest bqt=new ArrayBlockingQueueTest();
		for(int i=0,j;i<11;i++){
			//bq.add(null);
			//boolean r = bq.add(i);//队列满时异常、不可放null元素
			//System.out.println(r);
		}
		
		for(int i=0,j;i<20;i++){
			//boolean r = bq.offer(i);//队列满时返回false、不可放null元素
			//System.out.println(bq);
		}
		
		 
		
		bq.poll();//如果队列为空，则返回null
		//System.out.println(bq);
		
		//bq.remove();//如果队列为空，则抛出一个NoSuchElementException异常
		//System.out.println(bq);
		
		bq.peek();// 如果队列为空，则返回null
		//bq.element();// 如果队列为空，则抛出一个NoSuchElementException异常
		
		/*以上是queue接口，以下是ArrayBlockingQueue的额外接口*/
		for(int i=0,j;i<133;i++){
			//bq.put(i);//   如果队列满，则阻塞,等待
			//System.out.println(bq);
		}
		for(int i=0,j;i<133;i++){
			//bq.take();//   如果队列空，则阻塞,等待
			//System.out.println(bq);
		}
	
	}
	
}
