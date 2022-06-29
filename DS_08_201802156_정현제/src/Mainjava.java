import java.io.BufferedReader;
import java.io.FileReader;


class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}
class BinaryTree {
	Node rootNode = null;
	public void insertNode(int element) {//���ο� ��� ����
		if (rootNode == null) { //��Ʈ�� �� ���
			rootNode = new Node(element);
		} 
		else {
			Node head = rootNode;
			Node currentNode;

			while (true) {
				currentNode = head;
				if (head.value > element) { //������ ��Ʈ���� ���� ���, �������� Ž��
					head = head.leftChild;
					if (head == null) { //���� �ڽ� ��尡 ����ִ� ���, �ش� ��ġ�� �߰��� ��带 ����
						currentNode.leftChild = new Node(element);
						break;
					}
				} 
				else {
					head = head.rightChild; //������ ��Ʈ���� ū ���, ���������� Ž��
					if (head == null) { //������ �ڽ� ��尡 ����ִ� ���, �ش� ��ġ�� �߰��� ��带 ����
						currentNode.rightChild = new Node(element);
						break;
					}
				}
			}
		}
	}
	   public void inorderTree(Node root, int depth) {
	        if (root != null) {
	            inorderTree(root.leftChild, depth + 1);
	            System.out.print(root.value+" ");
	            inorderTree(root.rightChild, depth + 1);
	        }
	    }
}
public class Mainjava {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str = "";

		while((str = br.readLine())!=null){
			String[] basket1 = new String[9];
			basket1=str.split(" ");

			BinaryTree bt = new BinaryTree();
			int[] num = new int[9];
			for(int i=0;i<9;i++) {
				num[i]=Integer.parseInt(basket1[i]);
				bt.insertNode(num[i]);
			}
			bt.inorderTree(bt.rootNode,0);
			System.out.println();
		}
	}
}