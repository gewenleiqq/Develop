package p05_ThreadLocal;

import java.util.Random;

public class ThreadLocal1 implements Runnable {
	ThreadLocal<Person> threadLocal=new ThreadLocal<Person>();

	public static void main(String args[]){
		ThreadLocal1 t = new ThreadLocal1();
		 
		
		Thread t1=new Thread(t,"111111");
		
		Thread t2=new Thread(t,"222222");
		t1.start();
		t2.start();
		
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		Person person = getPersonInThreadLocal();
		person.setAge(random.nextInt(100));
		System.out.println(person.getAge());
	}
	 
	
	private Person getPersonInThreadLocal() {
		Person person = threadLocal.get();
        if (null == person) {
        	person = new Person();
        	threadLocal.set(person);
        }
        return person;
    }
	
	
	class Person{
		int age;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		
	}
}
 