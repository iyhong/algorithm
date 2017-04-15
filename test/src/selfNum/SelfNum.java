package selfNum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelfNum {
	public static void main(String[] args){
		
		int limit = 100;
		ArrayList result = new ArrayList();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer i=1; i<limit; i++){
			System.out.println("i:"+i);
			map.put(i, 0);
			int sum = 0;
			String str = i.toString();
			if(str.length()>1){
				//System.out.println("i:"+i);
				//System.out.println("str길이"+str.length());
				Object[] array = new Object[str.length()];
				array = str.split("");
				sum = i;
				for(int j=0; j<str.length();j++){
					//System.out.println("array[j]:"+array[j]);
					sum += Integer.parseInt((String)array[j]);
					
				}
				//System.out.println(array[0]+","+array[1]);
				
			}else{
				sum = i+i;
			}
			System.out.println("sum:"+sum);
			map.put(sum, 1);
			//System.out.println("map.get(sum):"+map.get(sum));
		}
		for(int i=1; i<limit; i++){
			System.out.println("포map.get(i):"+map.get(i));
			if(map.get(i).equals("1")){
				System.out.println("i>>"+i);
				result.add(i);
			}
		}
		
		for(int i=0; i<result.size();i++){
			System.out.println("result:"+result.get(i));
		}
		
		
	}
}
