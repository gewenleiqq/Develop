package p01_String;

public class String2 {
	public static void say(String v){
		v=v+"b";
	}
	public static void main(String args[]){
		String v="a";
		say(v);
		System.out.println(v);
	}
}
