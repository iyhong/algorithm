package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();//세로
		int M = sc.nextInt();//가로
		int x = sc.nextInt();//세로 
		int y = sc.nextInt();//가로
		int K = sc.nextInt();

		
		//주사위 만들기
		int[][] dice = new int[4][3];
		//주사위 초기화
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				dice[i][j] = -1;
				if(i==1 || j==1) dice[i][j] = 0;
			}
		}

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<K; i++){
			int di = sc.nextInt();
			//System.out.println("큐넣는 di:"+di);
			q.offer(di);
		}
		
//		//주사위 출력 
//		for (int i = 0; i < 4; i++) {
//			System.out.print("( ");
//			for (int j = 0; j < 3; j++) {
//				System.out.print(dice[i][j] + " ");
//			}
//			System.out.println(")");
//		}
//		//지도 출력 
//		for (int i = 0; i < N; i++) {
//			System.out.print("( ");
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println(")");
//		}
		
		while(!q.isEmpty()){
			int direction = q.poll();
			//System.out.println(direction);
			int fail = 0;
			int temp = 0;
			switch (direction){
			//오른쪽으로 한칸 이동
			case 1:
				if(y+1>=M) {
					fail++;
					break;
				}
				y++;
				if(map[x][y]!=0){
					dice[1][2] = dice[3][1];
					dice[3][1] = dice[1][0];
					dice[1][0] = dice[1][1];
					dice[1][1] = map[x][y];
					map[x][y] = 0;
				}else{
					temp = dice[1][1];
					dice[1][1] = dice[1][2];
					dice[1][2] = dice[3][1];
					dice[3][1] = dice[1][0];
					dice[1][0] = temp;
					map[x][y] = dice[1][1];
				}
				break;
			//왼쪽으로 한칸 이동
			case 2:
				if(y-1<0) {
					fail++;
					break;
				}
				y--;
				if(map[x][y]!=0){
					dice[1][0] = dice[3][1];
					dice[3][1] = dice[1][2];
					dice[1][2] = dice[1][1];
					dice[1][1] = map[x][y];
					map[x][y] = 0;
				}else{
					temp = dice[1][1];
					dice[1][1] = dice[1][0];
					dice[1][0] = dice[3][1];
					dice[3][1] = dice[1][2];
					dice[1][2] = temp;
					map[x][y] = dice[1][1]; 
				}
				break;
			//위로 한칸 이동
			case 3:
				if(x-1<0) {
					fail++;
					break;
				}
				x--;
				if(map[x][y]!=0){
					dice[0][1] = dice[3][1];
					dice[3][1] = dice[2][1];
					dice[2][1] = dice[1][1];
					dice[1][1] = map[x][y];
					map[x][y] = 0;
				}else{
					temp = dice[1][1];
					dice[1][1] = dice[0][1];
					dice[0][1] = dice[3][1];
					dice[3][1] = dice[2][1];
					dice[2][1] = temp;
					map[x][y] = dice[1][1];
				}
 				break;
 			//아래로 한칸 이동
			case 4:
				if(x+1>=N) {
					fail++;
					break;
				}
				x++;
				if(map[x][y]!=0){
					dice[2][1] = dice[3][1];
					dice[3][1] = dice[0][1];
					dice[0][1] = dice[1][1];
					dice[1][1] = map[x][y];
					map[x][y] = 0;
				}else{
					temp = dice[1][1];
					dice[1][1] = dice[2][1];
					dice[2][1] = dice[3][1];
					dice[3][1] = dice[0][1];
					dice[0][1] = temp;
					map[x][y] = dice[1][1];
				}
				break;
			}
			//주사위 출력 
//			for (int i = 0; i < 4; i++) {
//				System.out.print("( ");
//				for (int j = 0; j < 3; j++) {
//					System.out.print(dice[i][j] + " ");
//				}
//				System.out.println(")");
//			}

			if(fail==0)
				System.out.println(dice[3][1]);
			
		}
	}
}
