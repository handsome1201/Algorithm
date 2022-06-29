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
	public boolean isEmpty() { //��� üũ
		return top==null;
	}
	public void push(char data) { //�� ���� �ֱ�
		StackNode newNode = new StackNode();
		newNode.data = data;
		newNode.link = top;
		top = newNode;
	}
	public char pop() { //�� �̱�

		char data = top.data;
		top = top.link;

		return data;
	}
	public char peek() { //�� Ȯ��

		return top.data;
	}
}

public class Mainjava {
	public static void main(String[] args) throws Exception{ 
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str = "";

		while((str = br.readLine())!=null)
		{
			char[] myChars = str.toCharArray();//�� char������ ��ȯ

			Stack s = new Stack();
			boolean res = true;

			int end, start;
			int len = myChars.length;
			if(len%2 == 0){//���ڿ��� ���̰� ¦���϶�
				end = len/2 - 1;
				start = len/2;
			}
			else{//���ڿ� ���̰� Ȧ���϶�
				end = len/2 - 1;
				start = len/2+1;
			}
			for(int i = 0; i <= end; i++) {
				s.push(myChars[i]);
			}
			char temp;//���ÿ��� pop�� ����
			for(int i = start; i < len; i++){
				if(!s.isEmpty()){
					temp = (char)s.pop();
					if(temp != myChars[i]){//���� �������� ���� �ʴٸ� ȸ���� �Ұ����� ����.
						res = false;
						break;//���̻� ���� �ʿ䰡 ����.
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

