import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BST<T> {
	public T item;
	public BST<T> left;
	public BST<T> right;
	public BST(T item) {  // 持失切
		this.item = item;
		left = null;
		right = null;
	}
}


class BSTree<T extends Comparable <T>> {
	private BST<T> root;

	public BSTree() {
		root = null;
	} // 持失切
	public boolean isEmpty(){
		return root == null;
	}
	public boolean insertByRecursion(T data){
		BST<T> newNode = new BST<T>(data);
		BST<T> tree = root;
		return insertByRecursion(newNode,tree);
	}
	public boolean insertByRecursion(BST<T> newNode, BST<T> tree) {
		if(isEmpty()){
			tree = root;
			root = newNode;
			return true;
		}
		else if(tree.item.compareTo(newNode.item)>0){
			if(tree.left == null){
				tree.left = newNode;
				return true;
			}
			return insertByRecursion(newNode, tree.left);
		}
		else if(tree.item.compareTo(newNode.item)<0){
			if(tree.right == null){
				tree.right = newNode;
				return true;
			}
			return insertByRecursion(newNode, tree.right);
		}
		else{
			return false;
		}
	}
	public boolean removeByRecursion(T data){
		if(isEmpty())
			return false;
		BST<T> tree = root;
		BST<T> tree_curr = null;
		return removeByRecursion(data, tree, tree_curr);
	}

	public boolean removeByRecursion(T data, BST<T> tree, BST<T> tree_curr){
		if(tree.item.compareTo(data)==0){
			boolean flag = false;
			BST<T> temp, temp_curr=null;
			temp = tree;
			if(temp.left == null){
				if(tree_curr == null){
					root = tree.right;
				}
				else if(tree_curr.item.compareTo(temp.item)>0)
					tree_curr.left = temp.right;
				else
					tree_curr.right = temp.right;
			}
			else{
				temp = temp.left;
				while(temp.right != null){
					flag = true;
					temp_curr = temp;
					temp = temp.right;
				}
				if(flag == true){
					temp_curr.right = null;
					temp.right = tree.right;
					temp.left = tree.left;
				}
				else
					temp.right = tree.right;
				if(tree==root)
					root = temp;
				else{
					if(tree_curr.item.compareTo(temp.item)>0)
						tree_curr.left = temp;
					else
						tree_curr.right = temp;
				}
			}
			return true;
		}
		else if(tree.item.compareTo(data)>0){
			if(tree.left == null)
				return false;
			return removeByRecursion(data, tree.left, tree);
		}
		else{
			if(tree.right == null)
				return false;
			return removeByRecursion(data, tree.right, tree);
		}
	}

	public boolean searchByRecursion(T data){
		BST<T> tree = root;
		return serchByRecursion(data, tree);
	}
	public boolean serchByRecursion(T data,BST<T> tree){
		if(tree.item.compareTo(data)==0)
			return true;
		else if(tree.item.compareTo(data)>0){
			if(tree.left == null)
				return false;
			return serchByRecursion(data, tree.left);
		}
		else{
			if(tree.right == null)
				return false;
			return serchByRecursion(data, tree.right);
		}
	}


}


public class Mainjava {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		String[] basket1=br.readLine().split(" ");
		int length=basket1.length;
		int[] insert1 = new int[length];
		for(int i=0;i<length;i++) {
			insert1[i]=Integer.parseInt(basket1[i]);
		}
		String[] basket2=br.readLine().split(" ");
		length=basket2.length;
		int[] search1 = new int[length];
		for(int i=0;i<length;i++) {
			search1[i]=Integer.parseInt(basket2[i]);
		}
		String[] basket3=br.readLine().split(" ");
		length=basket3.length;
		int[] remove = new int[length];
		for(int i=0;i<length;i++) {
			remove[i]=Integer.parseInt(basket3[i]);
		}
		String[] basket4=br.readLine().split(" ");
		length=basket4.length;
		int[] search2 = new int[length];
		for(int i=0;i<length;i++) {
			search2[i]=Integer.parseInt(basket4[i]);
		}
		
		BSTree<Integer> tree = new BSTree<Integer>();
		
		for(int i=0;i<insert1.length;i++) {
			tree.insertByRecursion(insert1[i]);
		}
		
		for(int i=0;i<search1.length;i++) {
			if (tree.searchByRecursion(search1[i])) {
				System.out.println("success");
			}
			else {
				System.out.println("fail");  
			}
		}
		System.out.println("----------------------------");
		for(int i=0;i<remove.length;i++) {
			tree.removeByRecursion(remove[i]);
		}
		for(int i=0;i<search2.length;i++) {
			if (tree.searchByRecursion(search2[i])) {
				System.out.println("success");
			}
			else {
				System.out.println("fail");  
			}
		}

	}
}
