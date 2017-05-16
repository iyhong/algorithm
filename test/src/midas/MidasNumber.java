package midas;

import java.io.IOException;
import java.util.Scanner;

public class MidasNumber {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		
		for(int i=2; i<N; i++){
			//System.out.println("i:"+i);
			for(int k=2; k<i+1; k++){
				if(i%k==0){
					if(k<=M){
						count++;
						//System.out.println("count++!!  k:"+k);
						break;
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}

