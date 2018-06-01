
public class gcd {
	public static int gcd(int p,int q){
		if(q==0) return p;
		int r= p%q;
		return gcd(q,r);
	}
	
	public static void main(String[] args){
		int a=gcd(3,6);
		
		System.out.println("result is "+a);
	}

}
