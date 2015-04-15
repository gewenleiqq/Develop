package p08_Thread;

public class InterruptTest {
	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread("1MyThread");
		t.start();
		Thread.sleep(100);// 睡眠100毫秒
		t.interrupt();// 中断t线程
		
		MyThread2 t2 = new MyThread2("2MyThread");
		t2.start();
		Thread.sleep(100);// 睡眠100毫秒
		t2.interrupt();// 中断t线程
	}
}
class MyThread extends Thread {
	int i = 0;
	public MyThread(String name) {
		super(name);
	}
	public void run() {
		while(!isInterrupted()) {// 当前线程没有被中断，则执行
			System.out.println(getName() + getId() + "执行了" + ++i + "次");
		}
	}
}

class MyThread2 extends Thread {  
    int i = 0;  
    public MyThread2(String name) {  
        super(name);  
    }  
    public void run() {  
        while(true) {// 死循环，等待被中断  
            System.out.println(getName() + getId() + "执行了" + ++i + "次");  
        }  
    }  
}  