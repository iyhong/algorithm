package grammer;

import java.util.ArrayList;
import java.util.List;

public class Question11 {
	public void takeList(ArrayList<? extends String> list) {
		//list.add("foo"); // 여기서 에러나는데 왜나는지 아는사람!
		Object o = list;
		String s = list.get(0);
		list = new ArrayList<String>(); 
	}
}
