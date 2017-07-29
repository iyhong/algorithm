package baekjoon1705;

import java.util.Arrays;
import java.util.Scanner;

//최대공약수 구하기
public class GreatestCommonMeasure {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long r =0;
		while(b!=0){
			r = a%b;
			a = b;
			b = r;
		}
		
		char[] s = new char[(int) a];
		Arrays.fill(s, '1');
		System.out.println(String.valueOf(s));
	
		
	}
}
