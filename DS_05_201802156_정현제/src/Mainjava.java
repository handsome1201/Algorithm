import java.io.BufferedReader;
import java.io.FileReader;


//연결 리스트로 사용 할 노드 class
class Node1 {
	private String data;
	private Node1 nextNode;

	public Node1(String data){
		this.data = data;
		this.nextNode = null;
	}
	//해당 노드를 원하는 노드(Node top)와 연결해주는 메소드
	public void linkNode(Node1 top){
		this.nextNode = top;
	}
	//해당 노드의 데이터를 가져오는 get메소드
	public String getData(){
		return this.data;
	}
	//해당 노드와 연결된 노드를 가져오는 get메소드
	public Node1 getNextNode(){
		return this.nextNode;
	}
}
class ListStack1 {
	private Node1 top;

	public ListStack1(){
		top = null;
	}
	public boolean isEmpty(){
		return (top==null);
	}
	public void push(String item){
		Node1 newNode = new Node1(item);
		newNode.linkNode(top);
		top = newNode;
	}
	public String peek(){
		return top.getData();
	}
	public String pop(){
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else{
			String item = peek();
			top = top.getNextNode();
			return item;
		}
	}
}	
class Node2 {
	private char data;
	private Node2 nextNode;

	public Node2(char data){
		this.data = data;
		this.nextNode = null;
	}
	//해당 노드를 원하는 노드(Node top)와 연결해주는 메소드
	public void linkNode(Node2 top){
		this.nextNode = top;
	}
	//해당 노드의 데이터를 가져오는 get메소드
	public char getData(){
		return this.data;
	}
	//해당 노드와 연결된 노드를 가져오는 get메소드
	public Node2 getNextNode(){
		return this.nextNode;
	}
}
class ListStack2 {
	private Node2 top;

	public ListStack2(){
		top = null;
	}
	public boolean isEmpty(){
		return (top==null);
	}
	public void push(char item){
		Node2 newNode = new Node2(item);
		newNode.linkNode(top);
		top = newNode;
	}
	public char peek(){
		return top.getData();
	}
	public char pop(){
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else{
			char item = peek();
			top = top.getNextNode();
			return item;
		}
	}
}
class print{
	public void cal(String str) {
		ListStack1 num = new ListStack1();
		ListStack2 calcu = new ListStack2();



		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
			}
			else if(str.charAt(i)=='.' && (str.charAt(i+1)>47 && str.charAt(i+1)<58)) {
				String sosu="";
				sosu=num.pop()+'.'+str.charAt(i+1);
				num.push(sosu);
				i++;
			}

			else if(str.charAt(i)==')') {
				String first="";
				String second="";
				double sum=0;
				second=num.pop();
				first=num.pop();

				if(calcu.peek()=='+') {
					sum=Double.parseDouble(first)+Double.parseDouble(second);
					num.push(String.valueOf(sum));
					calcu.pop();
				}
				else if(calcu.peek()=='-') {
					sum=Double.parseDouble(first)-Double.parseDouble(second);
					num.push(String.valueOf(sum));
					calcu.pop();
				}
				else if(calcu.peek()=='*') {
					sum=Double.parseDouble(first)*Double.parseDouble(second);
					num.push(String.valueOf(sum));
					calcu.pop();
				}
				else {
					sum=Double.parseDouble(first)/Double.parseDouble(second);
					num.push(String.valueOf(sum));
					calcu.pop();
				}

			}
			else if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/') {
				calcu.push(str.charAt(i));
			}
			else {
				if(i==str.length()-1) {
					if((str.charAt(i)>47 && str.charAt(i)<58) && (str.charAt(i-1)>47 && str.charAt(i-1)<58)) { 
						String pushnum=num.pop()+Character.toString(str.charAt(i));
						num.push(pushnum);
					}
				}
				else if(i<str.length()-2 && i!=0) { 
					if(!num.isEmpty() && str.charAt(i-1)=='(') {
						num.push(Character.toString(str.charAt(i)));
					}
					else if((str.charAt(i)>47 && str.charAt(i)<58) && (str.charAt(i-1)>47 && str.charAt(i-1)<58)) {
						String pushnum=num.pop()+Character.toString(str.charAt(i));
						num.push(pushnum);
					}
					else if((str.charAt(i)>47 && str.charAt(i)<58) && (str.charAt(i+1)>47 && str.charAt(i+1)<58)) { 
						String pushnum=num.pop()+Character.toString(str.charAt(i));
						num.push(pushnum);

					}
					else {
						num.push(Character.toString(str.charAt(i)));
					}
				}

				else {
					num.push(Character.toString(str.charAt(i)));

				}

			}
		}
		Double sum=0.0;
		if(!num.isEmpty() && !calcu.isEmpty()) {
			String first="";
			String second="";
			second=num.pop();
			first=num.pop();

			if(calcu.peek()=='+') {
				sum=Double.parseDouble(first)+Double.parseDouble(second);
			}
			else if(calcu.peek()=='-') {
				sum=Double.parseDouble(first)-Double.parseDouble(second);
			}
			else if(calcu.peek()=='*') {
				sum=Double.parseDouble(first)*Double.parseDouble(second);
			}
			else {
				sum=Double.parseDouble(first)/Double.parseDouble(second);
			}
		}
		double result1 = Math.round(sum * 100) / 100.0;	
		System.out.println(result1);
	}
}
public class Mainjava {
	public static void main(String[] args) throws Exception{ 

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str = "";

		while((str = br.readLine())!=null)
		{
			print pt = new print();
			pt.cal(str);	
		}
	}
}











