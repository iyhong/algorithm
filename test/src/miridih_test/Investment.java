package miridih_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//문제 제목 : 주식 투자 
//프로그램의 핵심 알고리즘을 간략히 기술
//  현재의 위치를 기준으로 현재위치부터 끝까지의 최대값과 위치를 구하고 
//  현재위치가 최대값이면 주식을 판다.(주식이 없는경우 아무것도 안함)
//  현재위치가 최대값이 아니면 주식을 산다.(뒤에 최대값이 있으므로 그때 팔면 이득)

import java.util.Scanner;

public class Investment {
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner sc = new Scanner(new FileInputStream("src/miridih_test/04-주식투자-input02.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase=0; testcase<T; testcase++){
			
			int stock = 0;//주식수량
			int money = 0;//가진 돈 현
			
			int N = sc.nextInt();
			int[] array = new int[N];

//			입력받은 숫자를 배열에 담는다.
			for(int i=0; i<N; i++){
				array[i] = sc.nextInt();
			}
//			기준을 배열 index 0부터 시작해서 마지막 index까지 옮겨가면서 실행한다.
			for(int i=0; i<N; i++){
				int maxPosition = -1;//최대값의 위치를 기록한다.
				int maxValue = 0;//최대값을 기록한다.
//				System.out.println("i:"+i);	
//				현재위치부터 마지막 index까지의 최대값과 위치를 구한다.
				for(int j=i; j<N;j++ ){
					if(array[j]>maxValue){
						maxValue = array[j];
						maxPosition = j;
					}
				}
//				System.out.println("maxPosition:"+maxPosition);
//				현재 위치가 최대값인 위치이면
//				주식이 있으면 팔고, 없으면 아무것도 안한다.
				if(i==maxPosition){
					if(stock>0){
						money += stock*array[i];
						stock = 0;
						continue;
					}
					continue;
//				현재위치가 최대값이 아니면 뒤에 최대값이 있으므로 그때 팔면 이득이된다.
//				그러므 주식을 산다.
				}else{
					stock++;
					money -= array[i];
				}
//				System.out.println("stock:"+stock);
//				System.out.println("money:"+money);
			}
			System.out.println(money);
		}
		
	}
}
