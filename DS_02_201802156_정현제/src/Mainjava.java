import java.io.BufferedReader;
import java.io.FileReader;


class Node {
	int data;
	Node next =null;

	Node(int data) {
		this.data = data;
	}
	
	public void delete(Node point) { //��� ���� ����	

		if(point.next.next!=null){
            point.next=point.next.next;
        }else{
            point.next=null;
        }
		
	}

    public void insert(int p) { //������ ���� �� ��������
        Node point =this;
        Node newNode = new Node(p);

        while(point.next!=null){ //���� ��ġ�� �����Ͱ� ����������
            if(point.next.data<p) { //���� �����Ͱ� �Է� ���� ������ ������
            	break; //point ��ġ �̵� �ߴ�
            }
            point=point.next; //����Ʈ ��ġ �̵�
        }
        if(point.next!=null){ //���� ��ġ�� �����Ͱ� ���� ���
            newNode.next=point.next;//���ο� ��� �����ؼ� ���� ��忡 �ٿ���
        }
        point.next=newNode;//���� ��ġ�� ���ο� ��忡 ���� �� �ٿ��ֱ�
    }


    public void modify(int a,int x) {
        Node point =this;
        int count=0;
        while(count!=a) { //�Է� ���� ����ŭ ����Ʈ �̵�
            point=point.next;
            count++; 
        }

        int data = point.next.data+x; //����Ʈ ��ġ ������ �� ����
        
        this.delete(point);//���� ��ȭ�� ��� ����
        this.insert(data);// ��� ����
    }


    public void print() {
        Node point =this.next;

        while(point.next!=null) {
            System.out.print(point.data+" ");
            point=point.next;
        }
        System.out.print(point.data);
    }

}


public class Mainjava {

	public static int[] num;
	public static int size;
	public static void main(String[] args) throws Exception{    
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));

			String[] problem = br.readLine().split(" ");
			size=problem.length; //���� ��� �ִ� �迭�� ũ��
			num = new int[size];

			for(int i=0;i<size;i++) {
				num[i]=Integer.parseInt(problem[i]);
			}

			Node selection = new Node(0); //��ü ����

			for(int i=0;i<size;i++) {
				selection.insert(num[i]); //���� ���� ���� ������������ �����ؼ� �־���
			}

			String str = "";
			while((str = br.readLine()) != null) {
				String[] point =new String[2];
				point = str.split(" ");
				int[] basket = new int[size];

				for(int i=0;i<2;i++) {
					basket[i]=Integer.parseInt(point[i]);
				}
				selection.modify(basket[0],basket[1]); //�� ����
			}
			selection.print(); //���
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}





