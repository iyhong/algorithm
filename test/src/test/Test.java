package test;

public class Test {
	public static void main(String[] args) {
		int n = 4;
		// 각 노드 경로의 길이, 0은 나 자신
		// 99 는 가는 경로가 없다는 뜻
		// ex. 1->3으로 가는 경로가 없다는 뜻
		int weight[][] = { 
				{  0,  3, 99,  6},
				{  3,  0,  2,  5},
				{ 99,  2,  0,  3},
				{  6,  5,  3,  0} };

		// 바로 전의 노드
		// ex. 1에서는 2,4,5 로 가는 경로만 존재
		int path[][] = { 
				{ 0, 1, 0, 1},
				{ 2, 0, 2, 2}, 
				{ 0, 3, 0, 3},
				{ 4, 4, 4, 0} };

		floyd(n, weight, path);

		System.out.println("최단경로 배열");
		print_arr(weight, n);
	}

	static void floyd(int n, int W[][], int D[][]) {
		int i, j, k;
		D = W;

		for (k = 0; k < n; k++) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
//					System.out.println("D["+i+"]["+j+"]("+D[i][j]+") <= D["+i+"]["+k+"]("+D[i][k]+") + D["+k+"]["+j+"]("+D[k][j]+")");

					boolean result = false;
					if(D[i][j] <= D[i][k] + D[k][j]){
						result = true;
					}
					D[i][j] = (D[i][j] <= D[i][k] + D[k][j] ? D[i][j] : D[i][k] + D[k][j]);
					// D[i][j] <= D[i][k] + D[k][j] 조건에서
					// D[i][j]이 더 작거나 같은 경우. 나 자신일 경우, 혹은 바로 가는 경로가 존재하는 경우
					// D[i][j]
					// 그게 아니라면 (바로 가는 경로가 없다면 99)
					// ex. 1->3 으로 가는 경우에, 1->3으로 바로 갈 수 있는 경우가 없다면
					// 1). 1->2, 2->3
					// 2). 1->4, 4->3
					// 계속 반복을 돌면서 가장 적은 수(최단경로)를 D[i][j] 에 넣는다.
					System.out.println("D["+i+"]["+j+"]("+D[i][j]+") <= D["+i+"]["+k+"]("+D[i][k]+") + D["+k+"]["+j+"]("+D[k][j]+") result:"+result);
				}
			}
		}
	}

	static void print_arr(int arr[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
