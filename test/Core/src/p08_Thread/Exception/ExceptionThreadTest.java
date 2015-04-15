package p08_Thread.Exception;

class ExceptionThread implements  Runnable {
	public void run() {
		Integer.valueOf("0-");
	}
}
public class ExceptionThreadTest{
	public static void main(String args[]){
		Thread t=new Thread(new ExceptionThread());
		t.setUncaughtExceptionHandler(new ExceptionHandler());//设置当前线程处理异常类
		//t.setDefaultUncaughtExceptionHandler(new ExceptionHandler());//应用里的所有线程对象建立异常 handler
		t.start();
	}
}