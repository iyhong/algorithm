package baekjoon;

//백준 1260번

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class DfsAndBfs {
	
	static int N;
	static int M;
	static int V;
	static int[][] ar;
	static int[] visited;
	
	//재귀방식으로 dfs 구현
	public static void dfs(int start){
		visited[start-1] = 1;
		System.out.print(start+" ");
		for(int i=0; i<N; i++){
			if(ar[start-1][i]==1 && visited[i]==0){
				dfs(i+1);
			}
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();//정점의 개수
		M = sc.nextInt();//간선의 개수
		V = sc.nextInt();//탐색시작 정점
		ar = new int[N][N];
		visited = new int[N];
		
		for(int i=0; i<M ;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			ar[x-1][y-1] = 1;
			ar[y-1][x-1] = 1;
		}
		
//		for(int i=0; i<N ;i++){
//			System.out.print("( ");
//			for(int j=0; j<N; j++){
//				System.out.print(ar[i][j]+" ");
//			}
//			System.out.println(")");
//		}
		
		int current = 0;
		current = V;
//		//결과담을 큐
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);

		//dfs
//		Stack<Integer> st = new Stack<Integer>();
//		visited = new int[N];
//		st.push(V);
//		visited[current-1] = 1;
//		
//		
//		while(!st.isEmpty()){
//			int node = 0;
//			current = st.peek();
//			for(int j=1; j<=N; j++){
//				if(ar[current-1][j-1]==1&&visited[j-1]==0){
//					node = j;
//					visited[node-1] = 1;
//					st.push(node);
//					q.offer(node);
//					//System.out.println("node:"+node);
//					break;
//				}
//			}
//			if(node==0){
//				st.pop();
//			}
//		}
//		
//		while(!q.isEmpty()){
//			System.out.print(q.poll()+" ");
//		}
		
		dfs(V);
		
		System.out.println();
		
//		for(int i=0; i<N; i++){
//			System.out.print(visited[i]);
//		}
		
		//visited 초기화
		for(int i=0; i<N; i++){
			visited[i] = 0;
		}
		
		
		//bfs
		ArrayList<Integer> list = new ArrayList<Integer>();
		q.offer(V);
		list.add(V);
		visited[V-1] = 1;
		while(!q.isEmpty()){
			current = q.poll();
			//System.out.println("current:"+current);
			for(int i=0; i<N; i++){
				if(ar[current-1][i]==1&&visited[i]==0){
					//System.out.println("i:"+i);
					q.offer(i+1);
					list.add(i+1);
					visited[i] = 1;
				}
			}
		}
		for(int a : list){
			System.out.print(a+" ");
		}
	}
}
