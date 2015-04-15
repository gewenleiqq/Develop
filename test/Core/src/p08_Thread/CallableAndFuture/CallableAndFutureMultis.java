package p08_Thread.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 其实也可以不使用CompletionService，可以先创建一个装Future类型的集合，
 * 用Executor提交的任务返回值添加到集合中，最后遍历集合取出数据
 * @author Administrator
 *
 */
public class CallableAndFutureMultis {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		for(int i = 1; i < 5; i++) {
			final int taskID = i;
			cs.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					return taskID;
				}
			});
		}
		
		// 可能做一些事情
		for(int i = 1; i < 5; i++) {
			try {
				System.out.println(cs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
} 