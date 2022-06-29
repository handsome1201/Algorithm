import java.io.BufferedReader;
import java.io.FileReader;

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

			Mainjava selection = new Mainjava(); //객체 생성

			for(int i=0;i<size;i++) {
				num[i]=Integer.parseInt(problem[i]);
			}

			for(int i=0;i<size;i++) {
				selection.insert(num[i]); //선택 정렬 통해 오름차순으로 정렬해서 넣어줌
			}

/*			String str = "";
			while((str = br.readLine()) != null) {
				String[] point =new String[2];
				point = str.split(" ");
				int[] basket = new int[size];

				for(int i=0;i<2;i++) {
					basket[i]=Integer.parseInt(point[i]);
				}
				selection.modify(basket[0],basket[1]); //값 변경

				for(int i=0;i<size;i++) {
					selection.insert(num[i]); //선택 정렬 통해 오름차순으로 정렬해서 넣어줌
				}

			}
*/
			selection.print(); //출력
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}



	public void insert(int x) { //선택 정렬 통해 오름차순으로 정렬
		size = num.length;
		int min; //최소값을 가진 데이터의 인덱스 저장 변수
		int temp;

		for(int i=0; i<size-1; i++){ 
			min = i;

			for(int j=i+1; j<size; j++){ 
				if(num[min] > num[j]){
					min = j;
				}
			}
			temp = num[min];
			num[min] = num[i];
			num[i] = temp;
		}
	}
	public void modify(int a,int x) {
		num[a]+=x;
	}

	public void print() {
		for(int i=0;i<size;i++) {
			System.out.println(num[i]);
		}
	}
}


