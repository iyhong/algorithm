package baekjoon;

//백준 1100번

import java.util.Scanner;

public class WhiteCell {
	static int count;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = 8;
		String[] str = new String[n];
		for(int i=0; i<n; i++){
			//문자열받아서 배열로 나누고
			str = sc.nextLine().split("");
			//홀수번째 줄은 짝수번째 행만
			if(i%2==0){
				for(int j=0; j<n; j+=2){
					if(str[j].equals("F")){
						count++;
					}
				}
			//짝수번째 줄은 홀수번째 행만
			}else{
				for(int j=1; j<n; j+=2){
					if(str[j].equals("F")){
						count++;
					}
				}
			}
			
		}
		System.out.println(count);
		
	}
}
