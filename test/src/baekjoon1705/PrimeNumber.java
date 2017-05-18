package baekjoon1705;

import java.util.Scanner;
// 백준 2581번 소수
public class PrimeNumber {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;
		int[] array = new int[10001];
		int count = 0;
		
		//소수 구하는 알고리즘
		//2에서부터 현재숫자까지 나눈 나머지가 0이 나오면
		//그때 나눈 값이 자기자신이 아니면 소수가 아닌것이므로 break로 반복문 나감
		//자기자신이면 소수임.
		for(int i=m; i<=n; i++){
			for(int j=2; j<=i; j++){
				int a = i % j;
				//System.out.println("i:"+i+", j:"+j+", a:"+a);
				if(a==0){
					if(i!=j){
						break;
					}else{
						sum += i;
						array[count] = i;
						count++;
						//System.out.println("sum:"+sum);
						//System.out.println("i:"+i);
					}
				}
			}
		}
		if(sum !=0){
			System.out.println(sum);
			System.out.println(array[0]);
		}else{
			System.out.println(-1);
		}
	}
}
