package midas;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TrumpCard {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int[] before = new int[13];
		int[] after = new int[13];
		
		for(int i=0; i<13; i++){
			before[i] = sc.nextInt();
		}
		
		for(int i=0; i<13; i++){
			after[i] = sc.nextInt();
		}
		
		
		int count = 0;
		for(int i=0; i<13; i++){
			count++;
//			Stack<Integer> s = new Stack<Integer>();
//			s.push(i);
			int temp = before[i];
			//인덱스찾기 
			int k;
			for(k=0; i<13; k++){
				if(temp==after[k]){
					break;
				}
			}
			if(k==12){
				continue;
			}
			for(int a=i+1; a<12; a++){
				
				for(int b=k+1; b<12; b++){
					if(before[a] == after[b]){
						
					}
				}
			}
			
		}
		
	}
}
