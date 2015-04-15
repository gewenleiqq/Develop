package p02_Collection.map;

public class HashSetHashtableHashMap {
/*	1:HashSet底层采用的是HashMap进行实现的，但是没有key-value，只有HashMap的key set的视图，
	HashSet不容许重复的对象

	2:Hashtable是基于Dictionary类的，而HashMap是基于Map接口的一个实现

	3:Hashtable里默认的方法是同步的，而HashMap则是非同步的，因此Hashtable是多线程安全的

	4:HashMap可以将空值作为一个表的条目的key或者value,HashMap中由于键不能重复，
	因此只有一条记录的Key可以是空值，而value可以有多个为空，但HashTable不允许null值(键与值均不行)

	5:内存初始大小不同，HashTable初始大小是11，而HashMap初始大小是16

	6:内存扩容时采取的方式也不同，Hashtable采用的是2*old+1,而HashMap是2*old。

	7:哈希值的计算方法不同，Hashtable直接使用的是对象的hashCode,
	而HashMap则是在对象的hashCode的基础上还进行了一些变化*/
	
	public static void main(String args[]){
		System.out.println(2/1000007);
	}
}
