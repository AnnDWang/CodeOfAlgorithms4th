

/***
 * 是Dijkstra双栈算数表达式求值算法
 * 表达式由括号、运算符和操作数（数字）组成。根据以下4中情况从左到右逐个将这些实体送入栈处理：
 * 将操作数压入操作数栈
 * 将运算符压入运算符栈
 * 忽略左括号
 * 在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
 */
public class Evaluate {
	public static void main(String[] args){
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		StdOut.println("请输入算数表达式：");
		while(!StdIn.isEmpty()){
			//读取字符，如果是运算符则压入栈
			String s=StdIn.readString();
			if(s.equals("("))
				;
			else if(s.equals("+"))
				ops.push(s);
			else if(s.equals("-"))
				ops.push(s);
			else if(s.equals("*"))
				ops.push(s);
			else if(s.equals("/"))
				ops.push(s);
			else if(s.equals("+"))
				ops.push(s);
			else if(s.equals("sqrt"))
				ops.push(s);
			else if(s.equals(")")){
				//如果是右括号，弹出运算符和操作数，计算结果并压入栈
				String op=ops.pop();
				double v=vals.pop();
				if(op.equals("+")) v=vals.pop()+v;
				else if(op.equals("-")) v=vals.pop()-v;
				else if(op.equals("*")) v=vals.pop()*v;
				else if(op.equals("/")) v=vals.pop()/v;
				else if(op.equals("sqrt")) v=Math.sqrt(v);
				vals.push(v);
			}
			else
				//如果既不是运算符，也不是括号，将它作为double压入栈
				vals.push(Double.parseDouble(s));
				
		}
		StdOut.println(vals.pop());
	}

}
