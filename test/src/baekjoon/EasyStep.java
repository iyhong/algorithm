package baekjoon;

import java.util.Scanner;

public class EasyStep {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		int[][] d = new int[101][10];
		//N이 1인 즉 한자리수는 경우의 수가 1이므로 1로넣어줌
		//0으로 시작하는 수는 없음 
		for(int i=1; i<=9; i++){
			d[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++){
			for(int j=0; j<=9; j++){
				//j가 0일때는 -1하면 안되므로 j+1인경우만 넣음 
				if(j==0){
					d[i][j] = d[i-1][j+1];
				//j가 9일때는 +1하면 안되므로 j-1인경우만 넣음
				}else if(j==9){
					d[i][j] = d[i-1][j-1];
				}else{
					d[i][j] = d[i-1][j-1] + d[i-1][j+1];
				}
			}
		}
		for(int i=0; i<=9; i++){
			result += d[N][i];
		}
		result %= 1000000000;
		System.out.println(result);
		
	}
}
