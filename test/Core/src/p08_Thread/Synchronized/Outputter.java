package p08_Thread.Synchronized;

 
 
public class Outputter {
	public void output(String name) {
		// TODO 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for(int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
			// Thread.sleep(10);
		}
	}
	
	public synchronized void outputSynchronized(String name) {
		// TODO 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for(int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
			// Thread.sleep(10);
		}
	}
	
	/**
	Object lock = new Object();  
	synchronized (lock) {  
	    for(int i = 0; i < name.length(); i++) {  
	        System.out.print(name.charAt(i));  
	    }  
	}  

	每次进入output方法都会创建一个新的lock，这个锁显然每个线程都会创建，没有意义。
	*/
}