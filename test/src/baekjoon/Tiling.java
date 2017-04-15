package baekjoon;

//2xn 타일
//백준 11726번 
import java.util.Scanner;

public class Tiling {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] ar = new int[1001];
		
		int n = sc.nextInt();
		//0개와 1개는 1가지 경우밖에 없다.
		ar[0] = 1;
		ar[1] = 1;
		
		//DP문제로 2x2와 2x1의 경우가 계속 반복되므로
		//이를 이용해 n까지 만든다.
		for(int i=2; i<=n;i++){
			ar[i] = ar[i-2] + ar[i-1];
			ar[i] %= 10007;
		}
		System.out.println(ar[n]);
	}
}
