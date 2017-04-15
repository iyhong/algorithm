package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	
	static int[][] graph = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int n = 0;
    static int m = 0;
    static int row[] = { 1, -1, 0, 0 };
    static int col[] = { 0, 0, 1, -1 };
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		String nString = "";
        for (int i = 0; i < n; i++) {
            nString = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(nString.charAt(j) + "");
            }
        }
        
//        
//		for(int i=0; i<n; i++){
//			String str = sc.next();
//			//System.out.println(str.split("")[1]);
//			for(int j=0; j<m; j++){
//				//System.out.println("j:"+j);
//				graph[i][j] = Integer.parseInt(str.split("")[j]);
//				visited[i][j] = false;
//			}
//		}
		
//		for(int i=0; i<n; i++){
//			//System.out.println(str.split("")[1]);
//			for(int j=0; j<m; j++){
//				System.out.print(graph[i][j]);
//			}
//			System.out.println();
//		}
		int roadCount = 0;
		int qSize = 0;
		int r = 0;
		int c = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);//0,0을 넣음
		
		point:
		while(true){
			qSize = q.size();
			
			for(int i=0; i<qSize; i++){
				int temp = q.poll();
				r = temp/1000;
				c = temp%1000;
				
				if(r==n-1 && c==m-1){
					roadCount++;
					System.out.println(roadCount);
					break point;
				}
				
				for(int j=0; j<4; j++){
					int nr = r + row[j];
					int nc = c + col[j];
					
					if(nr<0 || nc<0 || nr>n || nc >m){
						continue;
					}
					
					if(visited[nr][nc]){
						continue;
					}
					
					if(graph[nr][nc]==0){
						continue;
					}
					
					visited[nr][nc] = true;
					temp = nr*1000+nc;
					q.offer(temp);
					
				}
				
			}
			roadCount++;
			
		}
		
	}
}
