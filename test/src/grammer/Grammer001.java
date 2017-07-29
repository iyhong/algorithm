package grammer;

import java.util.HashSet;

public class Grammer001 {
	public static void main(String[] args){
		String s1 = new String("hello");
		String s2 = new String("hello");
		String s3 = new String("hello1");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		HashSet<Object> hs = new HashSet<Object>();
		
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		System.out.println(hs.size());
	}
	
}
