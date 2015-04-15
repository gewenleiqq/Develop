package p08_Thread.ProducersAndConsumers;

import java.util.ArrayList;
import java.util.List;
/** 定义一个盘子类，可以放鸡蛋和取鸡蛋 */
public class Plate {
	/** 装鸡蛋的盘子 */
	List<Egg> eggs = new ArrayList<Egg>();
	/** 取鸡蛋 */
	public synchronized Egg getEgg() {
		while (eggs.size() == 0) {
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("拿到鸡蛋前"+eggs.size());
		Egg egg = eggs.get(0);
		eggs.clear();// 清空盘子
		notify();// 唤醒阻塞队列的某线程到就绪队列
		System.out.println("拿到鸡蛋后"+eggs.size());
		return egg;
	}
	/** 放鸡蛋 */
	public synchronized void putEgg(Egg egg) {
		while (eggs.size() > 0) {
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("放入鸡蛋前"+eggs.size());
		eggs.add(egg);// 往盘子里放鸡蛋
		notify();// 唤醒阻塞队列的某线程到就绪队列
		System.out.println("放入鸡蛋后"+eggs.size());
	}
	
	public static void main(String args[]) {
		Plate plate = new Plate();
		for(int i = 0; i < 10; i++) {
			new Thread(new AddThread(plate)).start();
			new Thread(new GetThread(plate)).start();
		}
	}
}

class AddThread implements Runnable{
	private Plate plate;
	
	public AddThread(Plate plate) {
		this.plate = plate;
	}
	public void run() {
		plate.putEgg(getEgg());
	}
	public Egg getEgg(){
		Egg egg = new Egg();
		egg.setId(java.util.UUID.randomUUID().toString());
		return egg;
	}
}
class GetThread implements Runnable{
	private Plate plate;
	public GetThread(Plate plate) {
		this.plate = plate;
	}
	public void run() {
		plate.getEgg();
	}
}
class Egg{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}