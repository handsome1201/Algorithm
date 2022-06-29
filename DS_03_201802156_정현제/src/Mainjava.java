import java.io.*;

class Node {
	char key;
	int data;

	Node next =null;

	Node(char key,int data) {
		this.data = data;
		this.key=key;
	}

	public void insert(char key, int data) { //데이터 삽입 후 버블정렬
		Node point =this;
		Node newNode = new Node(key,data);

		while(point.next!=null){ //다음 위치에 데이터가 없을때까지
			if(point.next.key>key) { //다음 데이터가 입력 받은 값보다 크면
				break; //point 위치 이동 중단
			}
			point=point.next; //포인트 위치 이동
		}
		if(point.next!=null){ //다음 위치에 데이터가 없을 경우
			newNode.next=point.next;//새로운 노드 생성해서 기존 노드에 붙여줌
		}
		point.next=newNode;//다음 위치에 새로운 노드에 넣은 값 붙여주기
	}

	public void merge(Node second) {
		Node point = this;
		
		while(second!=null){ //2번 노드 다 순환할떄까지
			Node newNode = new Node(second.key,second.data); //2번 노드 값만 참조하는 노드
			
			if(second.key == point.key) { //만약 1번 노드와 2번 노드의 키 값이 같다면
				point.data=point.data+second.data; //데이터 서로 더해줌	
			}
			else if(point.next==null) { //1번 노드 마지막까지 왔다면
				point.next=newNode; //1번 노드 뒤에 값 추가
			}
			else if(second.key<point.next.key && second.key>point.key) { //2번 노드값이 1번 노드 값들 사이에 들어갈때
				newNode.next=point.next;
				point.next=newNode;
			}
			else { //값이 없을때 1번 노드 포인트 위치 이동
				point=point.next;
				continue;
			}
			second=second.next;	
			point=this;
		}
	}

	public void print() {
		Node point =this.next;

		while(point.next!=null) {
			System.out.print(point.key+": "+point.data+" ");
			point=point.next;
		}
		System.out.print(point.key+": "+point.data);
	}
}

public class Mainjava {

	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		Node list1 = new Node('0',0);
		Node list2 = new Node('0',0);

		for(int k=0;k<2;k++) {
			if(k==0) {
				String[] problem = br.readLine().split(" ");
				int size=problem.length; //값이 들어 있는 배열의 크기

				char[] english=new char[size/2];
				int[] num = new int[size/2];
				int en=0;
				int nu=0;
				for(int i=0;i<size;i++) {
					if(i%2==0) {
						english[en]=problem[i].charAt(0);
						en++;
					}
					else {
						num[nu]=Integer.parseInt(problem[i]);
						nu++;
					}
				}
				for(int  i=0;i<size/2;i++) {	
					list1.insert(english[i], num[i]);
				}
				list1.print();
				System.out.println();
			}
			if(k==1) {
				String[] problem = br.readLine().split(" ");
				int size=problem.length; //값이 들어 있는 배열의 크기

				char[] english=new char[size/2];
				int[] num = new int[size/2];
				int en=0;
				int nu=0;
				for(int i=0;i<size;i++) {
					if(i%2==0) {
						english[en]=problem[i].charAt(0);
						en++;
					}
					else {
						num[nu]=Integer.parseInt(problem[i]);
						nu++;
					}
				}
				for(int  i=0;i<size/2;i++) {	
					list2.insert(english[i], num[i]);
				}
				list2.print();
			}
		}
		System.out.println();
		list1.merge(list2);
		list1.print();
	}
}