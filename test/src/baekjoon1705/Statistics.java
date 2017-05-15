package baekjoon1705;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Statistics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		int average = 0;
		int middle = 0;
		int frequency = 0;
		int range = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 평균 구하기
		for (int i = 0; i < n; i++) {
			average += arr[i];
		}
		double tmpNum = (double)average / n;
		//System.out.println(tmpNum);
		average = (int) Math.round(tmpNum);
		
		System.out.println(average);

		// 중앙값 구하기
		Arrays.sort(arr);
//		for(int i=0; i<n; i++){
//			System.out.print(arr[i]+", ");
//		}
		middle = arr[((arr.length + 1) / 2) - 1];
		System.out.println(middle);

		// 최빈값 구하기
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int max = 1;
		for (int i = 0; i < n; i++) {
			// freq[arr[i]]++;
			if(map.get(arr[i])==null){
				//System.out.println("arr[i]:"+arr[i]);

				map.put(arr[i], 1);
				//System.out.println(map.get(arr[i]));

			}else{
				map.put(arr[i], map.get(arr[i]) + 1);
				//System.out.println(map.get(arr[i]));
			}
			
		}
		
		//System.out.println("시바:"+map.get(arr[0]));
		for (int i = 0; i < n; i++) {
			//System.out.println("arr[i]:"+arr[i]);
			if (max < map.get(arr[i])) {
				max = map.get(arr[i]);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (max == map.get(arr[i])) {
				list.add(arr[i]);
			}
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int tmp;
				if (list.get(i) > list.get(j)) {
					tmp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tmp);
				}
			}
		}
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.addAll(list);
		list = new ArrayList<Integer>();
		//Iterator<Integer> it = tree.iterator();
		list.addAll(tree);
//		for(int i=0; i<list.size(); i++){
//			System.out.print(list.get(i)+", ");
//		}
		frequency = list.get(1);
		System.out.println(frequency);

		// 범위 구하기
		range = -arr[0] + arr[n - 1];
		
		System.out.println(range);
		sc.close();

	}
}
