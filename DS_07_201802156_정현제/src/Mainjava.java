import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class DequeNode {
	int data;
	DequeNode frontlink;
	DequeNode lastlink;

	public DequeNode() {
		this.frontlink = null;
		this.lastlink = null;
	}

	public DequeNode(int data) {
		this.data = data;
		this.frontlink = null;
		this.lastlink = null;
	}
}
class Deque {
	DequeNode front;
	DequeNode last;

	public Deque() {
		front = null;
		last = null;
	}

	public boolean isEmpty(){
		return (front==null);
	}

	public void addFront(int item){
		DequeNode node = new DequeNode(item);
		if(isEmpty()){
			front = node;
			last = node;
			node.lastlink = null;
			node.frontlink = null;
		}
		else{
			node.lastlink = front;
			node.frontlink = null;
			front.frontlink = node;
			front = node;
		}
	}

	public int removefirst(){
		if(isEmpty()){
			return 0;
		}
		else{
			int data = front.data;
			if(front.lastlink==null){
				front = null;
				last = null;
			}else{
				front = front.lastlink;
				front.frontlink = null;
			}
			return data;
		}
	}

	public void addlast(int item){
		DequeNode node =  new DequeNode(item);
		if(isEmpty()){
			front = node;
			last = node;
			node.lastlink = null;
			node.frontlink = null;
		}else{
			node.frontlink = last;
			node.lastlink = null;
			last.lastlink = node;
			last = node;
		}
	}

	public int removelast(){
		if(isEmpty()){
			return 0;
		}else{
			int data = last.data;
			if(last.frontlink==null){
				front = null;
				last = null;
			}else{
				last = last.frontlink;
				last.lastlink = null;
			}
			return data;
		}
	}


	public void printqueue(){
		if(isEmpty()){
			System.out.println("queue is empty");
		}else{
			DequeNode node = front;
			while(node!=null){
				System.out.print(node.data + " ");
				node = node.lastlink;
			}
			System.out.println();
		}
	}
}


public class Mainjava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str = "";

		while((str = br.readLine())!=null){
			
			String[] basket = str.split(" ");
			int[] num=new int[basket.length];
			for(int i=0;i<basket.length;i++) {
				num[i] = Integer.parseInt(basket[i]);
			}
			Deque dq = new Deque();
			
			for(int i=0;i<num.length;i++) {
				dq.addFront(num[i]);
				dq.printqueue();
			}
			for(int i=0;i<num.length;i++) {
				dq.removefirst();;
				dq.printqueue();
			}
			System.out.println();
			System.out.println();
			for(int i=0;i<num.length;i++) {
				dq.addlast(num[i]);
				dq.printqueue();
			}
			for(int i=0;i<num.length;i++) {
				dq.removelast();
				dq.printqueue();
			}
			
			

		}


	}

}
