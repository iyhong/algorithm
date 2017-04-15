package miridih_test;

public class Quiz03 {
	public static void main(String[] args){
		int inputNum = 12;
		
		int num = 9;
		
		int multi = inputNum * num;
		
		int result = 0;
		
		int forCount = 0;
		
		for(int i=1; i<99999; i++){
			
			Integer value = multi*i;
			System.out.println(value);
			String[] array = value.toString().split("");
			//System.out.println("array[i]:"+array[0]);
			//배열에서 0과 9가 없으면 for문 탈출
			int count = 0;
			
//			for(int j=0; j<array.length;j++){
//				System.out.println("array[j]:"+array[j]);
//			}
			
			for(int j=0; j<array.length;j++){
				//System.out.println(array[j].equals("4"));
				if(array[j].equals("0") || array[j].equals("9")){
					count++;
				}
				//System.out.println("count:"+count);
			}
			if(count==array.length){
				result = value;
				forCount = i;
				break;
			}
			
		}
		System.out.println("result:"+result);
		System.out.println("반복횟수:"+forCount);
	}
}
