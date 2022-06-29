import java.io.BufferedReader;
import java.io.FileReader;


class Node {
	int data;
	Node next =null;

	Node(int data) {
		this.data = data;
	}
	
	public void delete(Node point) { //노드 연결 끊기	

		if(point.next.next!=null){
            point.next=point.next.next;
        }else{
            point.next=null;
        }
		
	}

    public void insert(int p) { //데이터 삽입 후 버블정렬
        Node point =this;
        Node newNode = new Node(p);

        while(point.next!=null){ //다음 위치에 데이터가 없을때까지
            if(point.next.data<p) { //다음 데이터가 입력 받은 값보다 작으면
            	break; //point 위치 이동 중단
            }
            point=point.next; //포인트 위치 이동
        }
        if(point.next!=null){ //다음 위치에 데이터가 없을 경우
            newNode.next=point.next;//새로운 노드 생성해서 기존 노드에 붙여줌
        }
        point.next=newNode;//다음 위치에 새로운 노드에 넣은 값 붙여주기
    }


    public void modify(int a,int x) {
        Node point =this;
        int count=0;
        while(count!=a) { //입력 받은 값만큼 포인트 이동
            point=point.next;
            count++; 
        }

        int data = point.next.data+x; //포인트 위치 다음에 값 수정
        
        this.delete(point);//값이 변화된 노드 삭제
        this.insert(data);// 노드 삽입
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
			size=problem.length; //값이 들어 있는 배열의 크기
			num = new int[size];

			for(int i=0;i<size;i++) {
				num[i]=Integer.parseInt(problem[i]);
			}

			Node selection = new Node(0); //객체 생성

			for(int i=0;i<size;i++) {
				selection.insert(num[i]); //버블 정렬 통해 내림차순으로 정렬해서 넣어줌
			}

			String str = "";
			while((str = br.readLine()) != null) {
				String[] point =new String[2];
				point = str.split(" ");
				int[] basket = new int[size];

				for(int i=0;i<2;i++) {
					basket[i]=Integer.parseInt(point[i]);
				}
				selection.modify(basket[0],basket[1]); //값 변경
			}
			selection.print(); //출력
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}





