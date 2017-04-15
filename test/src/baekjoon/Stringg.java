package baekjoon;

import java.util.Scanner;

//백준 1120 문자열

public class Stringg {
	static String[] a;
	static String[] b;
	static int cha;
	static int min;
	static int index;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		a = sc.next().split("");
		b = sc.next().split("");
		min = 99999;
		for(int i=0; i<b.length-a.length+1; i++){
			//System.out.println("i:"+i);
			cha = 0;
			for(int j=0; j<a.length; j++){
				//System.out.println("j:"+j);
				//System.out.println(a[j]+","+b[j+i]);
				if(!a[j].equals(b[j+i])){
					cha++;
				}
			}
			//System.out.println("cha:"+cha);
			//System.out.println("min:"+min);
			min = Math.min(min, cha);
		}
		System.out.println(min);
	}
}
