package baekjoon;

//붕어빵 판매하기
//

import java.util.Scanner;

public class FishBread {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] D = new int[1001];
		int[] P = new int[10001];
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N ; i++){
			P[i] = sc.nextInt();
		}
		
//		for(int i=0;i<N; i++){
//			System.out.print(P[i]);
//		}
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				D[i] = Math.max(D[i], P[j] + D[i-j]);
			}
		}
		System.out.println(D[N]);
	}
}
