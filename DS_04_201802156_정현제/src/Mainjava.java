import java.io.BufferedReader;
import java.io.FileReader;


class StackNode {
	char data;
	StackNode link;
}

class Stack {
	StackNode top;

	public Stack() {
		top = null;
	}
	public boolean isEmpty() { //빈거 체크
		return top==null;
	}
	public void push(char data) { //값 집어 넣기
		StackNode newNode = new StackNode();
		newNode.data = data;
		newNode.link = top;
		top = newNode;
	}
	public char pop() { //값 뽑기

		char data = top.data;
		top = top.link;

		return data;
	}
	public char peek() { //값 확인

		return top.data;
	}
}

public class Mainjava {
	public static void main(String[] args) throws Exception{ 
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str = "";

		while((str = br.readLine())!=null)
		{
			char[] myChars = str.toCharArray();//값 char형으로 변환

			Stack s = new Stack();
			boolean res = true;

			int end, start;
			int len = myChars.length;
			if(len%2 == 0){//문자열의 길이가 짝수일때
				end = len/2 - 1;
				start = len/2;
			}
			else{//문자열 길이가 홀수일때
				end = len/2 - 1;
				start = len/2+1;
			}
			for(int i = 0; i <= end; i++) {
				s.push(myChars[i]);
			}
			char temp;//스택에서 pop한 원소
			for(int i = start; i < len; i++){
				if(!s.isEmpty()){
					temp = (char)s.pop();
					if(temp != myChars[i]){//만약 비교했을때 같지 않다면 회문이 불가능한 숫자.
						res = false;
						break;//더이상 비교할 필요가 없음.
					}
				}
			}
			if(res == true) {
				System.out.println(str+" is Palinedrome");
			}
			else {
				System.out.println(str+" is not Palinedrome");
			}
		}

	}
}

