
/*****
 * 简单地计算标准输入中的所有double的值的平均值和样本标准差。
 * 如果标准输入中有N个数字，那么平均值为他们的和除以N
 * 样本标准差为每个值和平均值之差的平方之和除以N-1之后的平方根
 * 在这些计算中，数的计算顺序和结果无关，因此将它们保存在一个Bag对象中，并使用foreach语法来计算每个和
 */
public class Stats {
	public static void main(String[] args){
		Bag<Double> numbers= new Bag<Double>();
		
		while(!StdIn.isEmpty())
			numbers.add(StdIn.readDouble());
		
		int N=numbers.size();
		
		double sum=0.0;
		for(double x:numbers)
			sum+=x;
		double mean=sum/N;
		
		sum=0.0;
		for(double x:numbers)
			sum+=(x-mean)*(x-mean);
		
		double std=Math.sqrt(sum/(N-1));
		
		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std: %.2f\n", std);
	}
}
