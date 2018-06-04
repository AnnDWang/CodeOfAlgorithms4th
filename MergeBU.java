
public class MergeBU {
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		//����lgN�������鲢
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz=sz+sz)//sz�������С
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz,N-1));
	}
	
	
	
	public static void merge(Comparable[] a, int lo,int mid,int hi){
	    //��a[lo...mid]��a[mid+1...hi]�鲢����
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) //��a[lo..hi]���Ƶ�aux[lo..hi]
		    aux[k]=a[k];
			
		for(int k=lo;k<=hi;k++) //�鲢�ص�a[lo..hi]
		    if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
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
