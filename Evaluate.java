

/***
 * ��Dijkstra˫ջ��������ʽ��ֵ�㷨
 * ����ʽ�����š�������Ͳ����������֣���ɡ���������4������������������Щʵ������ջ������
 * ��������ѹ�������ջ
 * �������ѹ�������ջ
 * ����������
 * ������������ʱ������һ����������������������Ĳ�����������������Ͳ�������������ѹ�������ջ
 */
public class Evaluate {
	public static void main(String[] args){
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		StdOut.println("��������������ʽ��");
		while(!StdIn.isEmpty()){
			//��ȡ�ַ���������������ѹ��ջ
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
				//����������ţ�����������Ͳ���������������ѹ��ջ
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
				//����Ȳ����������Ҳ�������ţ�������Ϊdoubleѹ��ջ
				vals.push(Double.parseDouble(s));
				
		}
		StdOut.println(vals.pop());
	}

}