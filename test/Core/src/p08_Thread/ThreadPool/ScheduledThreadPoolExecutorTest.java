package p08_Thread.ThreadPool;


import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * ScheduledThreadPoolExecutor 定时任务线程池
 * 此类 类似于Timer ，但优于Timer
 * @author Administrator
 *
 */
public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args) {
		
		ScheduledThreadPoolExecutor poll = new ScheduledThreadPoolExecutor(1);
		
		poll.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println(Calendar.getInstance().getTime().toString());
			}
		}, 10 , 11, TimeUnit.SECONDS);
		
		
	}
	
}
