
public class UF {
	private int[] id;//分量id 以触点作为索引
	private int count;//分量数量
	public UF(int N){
		//初始化分量id数组
		count=N;
		id =new int[N];
		for(int i=0;i<N;i++)
			id[i]=i;
		
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p, int q){
		return find(p)==find(q);
	}
	
	public int find(int p){
		return id[p];
	}
	
	public void union(int p,int q){
		//将p和q归并到相同的分量中
		int pID=find(p);
		int qID=find(q);
		
		//如果p和q已经在相同的分量中则不需要采取任何行动
		if(pID==qID) return;
		
		//将p的分量重命名为q的名称
		for(int i=0;i<id.length;i++)
			if(id[i]==pID) id[i]=qID;
		count--;
	}
	
	public static void main(String[] args){
		//解决由StdIn得到的动态连通性问题
		int N=StdIn.readInt();//读取触点数量
		UF uf=new UF(N);//初始化N个分量
		while(!StdIn.isEmpty()){
			int p=StdIn.readInt();
			int q=StdIn.readInt();//读取整数对
			if(uf.connected(p, q)) continue;//如果已经连通，则忽略
			uf.union(p, q);//归并分量
			StdOut.println(p+" "+q);//打印连接
			
		}
		StdOut.println(uf.count()+"components");
	}

}
