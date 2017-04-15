package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 1697번 숨바꼭질

public class Sumbaggokjil {
	static int n;//수빈이위치
	static int k;//동생위치
	
	static int current;
	static int[] visited;
	
	static Queue<Integer> q;
	static int qSize;
	static int count;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		visited = new int[100001];
		q = new LinkedList<Integer>();
		
		q.offer(n);
		visited[n] = 0;
		
		//bfs 활용
		while(!q.isEmpty()){
			current = q.poll();
			//System.out.println("current:"+current);
			if(current == k){
				System.out.println(visited[current]);
				break;
			}
			if(current*2<=100000 && visited[current*2]==0){
				visited[current*2] = visited[current]+1;
				q.offer(current*2);
			}
			if(current+1 <=100000 && visited[current+1]==0){
				visited[current+1] = visited[current]+1;
				q.offer(current+1);
			}
			if(current-1 >= 0 && visited[current-1]==0){
				visited[current-1] = visited[current]+1;
				q.offer(current-1);
			}
		}
	}
}
