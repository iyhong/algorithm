package baekjoon;
//11403 경로찾기
import java.util.Scanner;

public class SearchPath {
	static int n;
	static int[][] graph;
	static int[][] result; //최종결과물
	static int[] temp; //각 시작노드마다 연결되는지 파악하는 배열
	
	
	//dfs 탐색으로 0에서 부터 탐색, 1에서부터탐색 ...n에서부터 탐색
	static void dfs(int start){
		//System.out.println("start:"+start);
		for(int i=0; i<n; i++){
			//System.out.println("i:"+i);
			if(graph[start][i]==1 && temp[i]==0){
				temp[i] = 1;
				//System.out.println(start+","+i+" 체크");
				dfs(i);
			}
		}
	}
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new int[101][101];
		result = new int[101][101];
		temp = new int[101];
		
		//입력받기
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				graph[i][j] = sc.nextInt();
			}
		}
		
//		for(int i=0; i<n; i++){
//			for(int j=0; j<n; j++){
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		//초기화
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				result[i][j] = 0;
			}
		}
		
		
		//탐색시작
		for(int i=0; i<n; i++){
			dfs(i);
			
			//탐색결과 temp에 담겨있는 결과를 결과를 담을 2차원배열로 옮긴다.
			for(int j=0; j<n; j++){
				result[i][j] = temp[j];
				//temp배열 초기화
				temp[j] = 0;
			}
		}
		
		//결과출력
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
