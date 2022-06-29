import java.io.*;

class Node {
	char key;
	int data;

	Node next =null;

	Node(char key,int data) {
		this.data = data;
		this.key=key;
	}

	public void insert(char key, int data) { //������ ���� �� ��������
		Node point =this;
		Node newNode = new Node(key,data);

		while(point.next!=null){ //���� ��ġ�� �����Ͱ� ����������
			if(point.next.key>key) { //���� �����Ͱ� �Է� ���� ������ ũ��
				break; //point ��ġ �̵� �ߴ�
			}
			point=point.next; //����Ʈ ��ġ �̵�
		}
		if(point.next!=null){ //���� ��ġ�� �����Ͱ� ���� ���
			newNode.next=point.next;//���ο� ��� �����ؼ� ���� ��忡 �ٿ���
		}
		point.next=newNode;//���� ��ġ�� ���ο� ��忡 ���� �� �ٿ��ֱ�
	}

	public void merge(Node second) {
		Node point = this;
		
		while(second!=null){ //2�� ��� �� ��ȯ�ҋ�����
			Node newNode = new Node(second.key,second.data); //2�� ��� ���� �����ϴ� ���
			
			if(second.key == point.key) { //���� 1�� ���� 2�� ����� Ű ���� ���ٸ�
				point.data=point.data+second.data; //������ ���� ������	
			}
			else if(point.next==null) { //1�� ��� ���������� �Դٸ�
				point.next=newNode; //1�� ��� �ڿ� �� �߰�
			}
			else if(second.key<point.next.key && second.key>point.key) { //2�� ��尪�� 1�� ��� ���� ���̿� ����
				newNode.next=point.next;
				point.next=newNode;
			}
			else { //���� ������ 1�� ��� ����Ʈ ��ġ �̵�
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
				int size=problem.length; //���� ��� �ִ� �迭�� ũ��

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
				int size=problem.length; //���� ��� �ִ� �迭�� ũ��

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