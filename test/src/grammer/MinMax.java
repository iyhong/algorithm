package grammer;

public class MinMax<N extends Number> {
	private N min, max;
	public N getMin() { return min; }
	public N getMax() { return max; }
	public void add(N added) {
		if (min == null || added.doubleValue() < min.doubleValue())
			min = added;
		if (max == null || added.doubleValue() > max.doubleValue())
			max = added;
	}
	
	public static void main(String[] args){
		MinMax m = new MinMax();
		m.add(10.111);
		System.out.println(m.min);
		System.out.println(m.max);
	}
}
