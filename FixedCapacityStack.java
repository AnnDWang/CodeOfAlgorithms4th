
public class FixedCapacityStack<Item> {
	private Item[] a;//stack entries
	private int N;//size
	public FixedCapacityStack(int cap){
		a=(Item[])new Object[cap];//创建泛型数组在java中是不允许的
	}
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		a[N++]=item;
	}
	
	public Item pop(){
		return a[--N];
	}

}
