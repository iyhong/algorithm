package miridih_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//문제 제목 : 배열의 무게중심
//프로그램의 핵심 알고리즘을 간략히 기술
//  배열의 두번째부터 마지막-1번째까지 기준을 옮겨가면서
//  왼쪽의 합을 구하고 오른쪽의 합을 구한후 비교한다.
//  합이 같으면 YES문자열을 넣고 반복문을 끝낸다.

import java.util.Scanner;

public class CenterOfGravity {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("src/miridih_test/02-배열의무게중심-input00.txt"));
		//Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase=0;testcase<T;testcase++){
			
			int N = sc.nextInt();
			String result = "NO";
			
			int[] array = new int[N];
			
			for(int i=0; i<N;i++){
				array[i] = sc.nextInt();
			}
			for(int i=1;i<N-1;i++){
				int left = 0;
				int right = 0;
//				System.out.println("i:"+i);
//				왼쪽 합 구하기
//				0번째 배열부터 i-1번째 배열까지 더한다.
				for(int j=0;j<i;j++){
					left += array[j];
				}
//				System.out.println("left:"+left);

//				오른쪽 합 구하기 
//				i+1번째 부터 마지막 배열까지 더한다.
				for(int j=i+1;j<N;j++){
					right += array[j];
				}
//				System.out.println("right:"+right);
				if(left==right){
					result = "YES";
					break;
				}
			}
			
			System.out.println(result);
		}
	}
}
