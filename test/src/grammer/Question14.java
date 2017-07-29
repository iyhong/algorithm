package grammer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question14 {
	public static void main(String[] args) {

		Set<Integer> set = new HashSet<Integer>();
		Integer i1 = 45;
		Integer i2 = 46;
		set.add(i1);
		set.add(i1);
		set.add(i2);
		System.out.print(set.size() + " ");//2
		set.remove(i1);
		System.out.print(set.size() + " ");//1
		print(set);//46
		
		i2 = 47;
		set.remove(46);
		System.out.print(set.size() + " ");
		print(set);
		
	}

	public static void print(Set set){
		Iterator i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
