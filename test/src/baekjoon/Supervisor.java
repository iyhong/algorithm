package baekjoon;

import java.util.Scanner;

public class Supervisor {
	static int N;//시험장 개수 
	static int[] A;//응시자 수
	static double B;//총 감독관이 감시할수 있는 수
	static double C;//부 감독관이 감시할수 있는 수
	
	static long main;
	static long sub; 
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		A = new int[1000001];
		N = sc.nextInt();
		for(int i=0; i<N; i++){
			A[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();
		
		for(int i=0; i<N; i++){
			double clazz = A[i];
			if(clazz>B){
				main++;
				double a = (clazz-B)/C;
				//System.out.println("a:"+a);
				if(a%1==0){
					//System.out.println("나누어떨어짐");
					sub += a;
				}else{
					//System.out.println("나누어떨어지지 않음");
					sub += Math.floor((clazz-B)/C)+1;
				}
				//System.out.println("for내부 sub:"+sub);
			}else{
				main++;
			}
		}
		//System.out.println("main:"+main);
		//System.out.println("sub:"+sub);
		long sum = main + sub;
		System.out.println(sum);
	}
}
