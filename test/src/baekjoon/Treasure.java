package baekjoon;

import java.util.Scanner;

//백준 1026번
public class Treasure {
	static int n;
	static int[] a;
	static int[] b;
	static int[] rank;
	static int[] temp;
	static int t;
	static int sum;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		b = new int[n];
		temp = new int[n];
		rank = new int[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++){
			b[i] = sc.nextInt();
		}
//		for(int i=0; i<n; i++){
//			System.out.print(a[i]);
//		}
//		System.out.println();
		
		//버블정렬
		int t = 0;
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-1-i;j++){
				if(a[j]>a[j+1]){
					t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}
		
		//temp에 a배열 복사
		for(int i=0; i<n; i++){
			temp[i] = a[i];
		}
		
		//랭킹구하는 포문
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(b[i]<b[j])
					rank[i]++;
			}
		}
		
		//랭킹중에 자기 자신을 제외하고 동일랭킹이 존재하면 +1을시켜준다.
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i!=j && rank[i]==rank[j]){
					rank[j]++;
				}
					
			}
		}
		
//		System.out.print("rank:");
//		for(int i=0; i<n; i++){
//			System.out.print(rank[i]);
//		}
//		System.out.println();
		
		//a배열을 복사해놓은 temp배열을 이용해
		//랭킹을 인덱스로 활용해 재배열한다.
		int rankNum = 0;
		for(int i=0; i<n; i++){
			rankNum = rank[i];
			a[i] = temp[rankNum];
		}
		
		//재배열된 a배열 출력
		System.out.print("a:");
		for(int i=0; i<n; i++){
			System.out.print(a[i]);
		}
		System.out.println();
		
		for(int i=0; i<n; i++){
			sum += a[i]*b[i];
		}
		System.out.println(sum);
	}
}
