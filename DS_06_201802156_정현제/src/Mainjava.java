import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	public void push(String i){
		Node1 newNode = new Node1(i);
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
	private String data;
	private Node1 nextNode;

	public Node2(String data){
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
class ListStack2 {
	private Node1 top;

	public ListStack2(){
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
public class Mainjava {
	static String result; // 변환식 (후위 표기법)
	static Double resultValue; // 계산 결과
	static ListStack1 stack = new ListStack1();
	static ListStack2 calStack = new ListStack2();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str = "";

		while((str = br.readLine())!=null){
			result = "";
			resultValue = 0.0;

			trans(str); 

			while(!stack.isEmpty()) {
				result += stack.pop();
			}
			System.out.print(result);
			System.out.print(" =");

			cal(result);
			resultValue = Math.round(Double.parseDouble(calStack.pop()) * 100) / 100.0;
			System.out.print(" "+resultValue);
			System.out.println();
		}

	}
	public static void cal(String sentence) {	
		String[] bag = sentence.split(" ");
		for(int i=0;i<bag.length;i++) {
			String cur= bag[i];
			String first="";
			String second="";
			if(cur.equals("*")) {
				second=calStack.pop();
				first=calStack.pop();
				Double tmp = Double.parseDouble(first)*Double.parseDouble(second);
				calStack.push(Double.toString(tmp));
			}
			else if(cur.equals("+")) {
				second=calStack.pop();
				first=calStack.pop();
				Double tmp = Double.parseDouble(first)+Double.parseDouble(second);
				calStack.push(Double.toString(tmp));
			}
			else if(cur.equals("-")) {
				second=calStack.pop();
				first=calStack.pop();
				Double tmp = Double.parseDouble(first)-Double.parseDouble(second);
				calStack.push(Double.toString(tmp));
			}
			else if(cur.equals("/")) {
				second=calStack.pop();
				first=calStack.pop();
				Double tmp = Double.parseDouble(first)/Double.parseDouble(second);
				calStack.push(Double.toString(tmp));
			}
			else {
				calStack.push(cur);
			}
		}

	}
	public static void  trans(String sentence) {
		
		for(int i=0;i<sentence.length();i++) {
			char cur=sentence.charAt(i);
			// '(' => 무조건 stack 에 쌓음
			if(cur == '(') {
				stack.push(Character.toString(cur));
			}
			// ')' => '(' 만날때 까지 stack의 내용 pop 하여 변환식에 넣음, '(' 는 버림
			else if(cur == ')') {
				while(!stack.isEmpty()) {
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
					else {
						result =result+stack.pop()+" ";
					}
				}
			}
			// '*' => 무조건 stack 에 쌓음 (*보다 우선순위인 연산자가 없음)
			else if(cur == '*') {
				if(stack.isEmpty()) {
					stack.push(Character.toString(cur));
				}
				else if(stack.peek().equals("/") || stack.peek().equals("*")){
					result = result+stack.pop()+" ";
					stack.push(Character.toString(cur));
				}
				else {
					stack.push(Character.toString(cur));
				}
			}
			// '/' => 무조건 stack 에 쌓음 (/보다 우선순위인 연산자가 없음)
			else if(cur == '/') {
				if(stack.isEmpty()) {
					stack.push(Character.toString(cur));
				}
				else if(stack.peek().equals("*") || stack.peek().equals("/")){
					result = result+stack.pop()+" ";
					stack.push(Character.toString(cur));
				}
				else {
					stack.push(Character.toString(cur));
				}
			}
			// '+' => 비어 있다면 stack 에 쌓음, 비어있지 않다면 '(' 만날때 까지 stack pop 하여 변환식에 넣음
			else if(cur == '+') {
				if(stack.isEmpty()) {
					stack.push(Character.toString(cur));
				}
				else{
					while(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							stack.push(Character.toString(cur));
							break;
						}
						else {
							result = result+stack.pop()+" ";
						}
					}
				}
			}
			// '-' => 비어 있다면 stack 에 쌓음, 비어있지 않다면 '(' 만날때 까지 stack pop 하여 변환식에 넣음
			else if(cur == '-') {
				if(stack.isEmpty()) {
					stack.push(Character.toString(cur));
				}
				else{
					while(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							stack.push(Character.toString(cur));
							break;
						}
						else {
							result = result+stack.pop()+" ";
						}
					}
				}
			}
			// 피연산자일 때 => 변환식에 넣음
			else {
				if(i!=sentence.length()-1 && (sentence.charAt(i+1)=='*' || sentence.charAt(i+1)=='+' 
						|| sentence.charAt(i+1)=='-' || sentence.charAt(i+1)=='/')) {
					result = result+Character.toString(cur)+" ";
				}
				else if(i!=sentence.length()-1 && sentence.charAt(i+1)>47 && sentence.charAt(i+1)<58){
					result = result+Character.toString(cur);
				}
				else if(i!=sentence.length()-1 && sentence.charAt(i+1)=='.') {
					result = result+Character.toString(cur);
				}
				else {
					result = result+Character.toString(cur)+" ";
				}
			}	
		}
	}
}	
