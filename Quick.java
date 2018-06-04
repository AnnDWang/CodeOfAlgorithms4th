
public class Quick {
	
private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);//��������������
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo,int hi){
		if(hi<=lo) return ;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);//����벿������
		sort(a,j+1,hi);//���Ұ벿������
	}
	
	private static int partition(Comparable[] a,int lo,int hi){
		//�������з�Ϊa[lo..i-1] a[i] a[i+1..hi]
		int i=lo,j=hi+1;//����ɨ��ָ��
		Comparable v=a[lo];//�з�Ԫ��
		while(true){
			//ɨ�����ң����ɨ���Ƿ����������Ԫ��
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);//��v=a[j]������ȷ��λ��
		return j;
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
		//�ڵ����д�ӡ����
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		//��������Ԫ���Ƿ�����
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args){
		//�ӱ�׼�����ȡ�ַ������������������
		Integer[] a={1,7,4,90,6,4,678,87,55,677,33,656,22,11};
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
