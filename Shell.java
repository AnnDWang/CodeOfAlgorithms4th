
public class Shell {
	public static void sort(Comparable[] a){
		// 将a[]按升序排列
		int N=a.length;
		int h=1;
		while (h<N/3) h=3*h+1;//1 4 14 40 121...
		while(h>=1){
			//将数组变为h有序
			for(int i=h;i<N;i++){
				//将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h=h/3;
		}
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable[] a){
		//在单行中打印数组
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		//测试数组元素是否有序
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args){
		//从标准输入读取字符串，将它们排序并输出
		Integer[] a={1,7,4,90,6,4,678,87,55,677,33,656,22,11};
		sort(a);
		assert isSorted(a);
		show(a);
	}
	
}
