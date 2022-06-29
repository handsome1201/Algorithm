import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Node {
	int key, height;
	Node left, right;

	Node(int d) {
		key = d;
		height = 1;
	}
}

class AVLTree {

	Node root;

	int tree_height(Node N) {
		if (N == null) {
			return 0;
		}
		else {
			return N.height;
		}
	}


	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(tree_height(y.left), tree_height(y.right)) + 1;
		x.height = max(tree_height(x.left), tree_height(x.right)) + 1;

		return x;
	}


	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(tree_height(x.left), tree_height(x.right)) + 1;
		y.height = max(tree_height(y.left), tree_height(y.right)) + 1;

		return y;
	}


	int getBalance(Node N) {
		if (N == null) {
			return 0;
		}
		else {
			return tree_height(N.left) - tree_height(N.right);
		}
	}

	Node insert(Node node, int key) {

		if (node == null)
			return (new Node(key));

		if (key < node.key) {
			node.left = insert(node.left, key);
		}
		else if (key > node.key) {
			node.right = insert(node.right, key);
		}
		else {
			return node;
		}

		node.height = 1 + max(tree_height(node.left),tree_height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key) {
			return rightRotate(node);
		}

		if (balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}


		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}


		return node;
	}

	Node minValue(Node node)
	{
		Node current = node;

		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	Node delete(Node root, int key)
	{
		if (root == null) {
			return root;
		}

		if (key < root.key) {
			root.left = delete(root.left, key);
		}

		else if (key > root.key) {
			root.right = delete(root.right, key);
		}

		else{
			if ((root.left == null) || (root.right == null)){
				Node temp = null;
				if (temp == root.left) {
					temp = root.right;
				}
				else {
					temp = root.left;
				}

				if (temp == null){
					temp = root;
					root = null;
				}
				else {
					root = temp; 
				}
			}
			else{
				Node temp = minValue(root.right);
				root.key = temp.key;
				root.right = delete(root.right, temp.key);
			}
		}

		if (root == null) {
			return root;
		}
	
		root.height = max(tree_height(root.left), tree_height(root.right)) + 1;

		int balance = getBalance(root);


		if (balance > 1 && getBalance(root.left) >= 0){
			return rightRotate(root);
		}
	
		if (balance > 1 && getBalance(root.left) < 0){
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}
		
		if (balance < -1 && getBalance(root.right) > 0){
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}
}

/////////////////////////////////////////////////////////////////////////////////

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
	private int height = 0;

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
	
	public int height() {
		if (isEmpty()) {
			return -1;
		}
		else {
			return heightCount(root, 0);
		}
	}

	private int heightCount(BST<T> tree, int i) {

		int left = -1, right = -1;

		if (tree.left != null) {
			left = heightCount(tree.left, i + 1);
		}
		if (tree.right != null) {
			right = heightCount(tree.right, i + 1);
		}
		if (tree.left == null && tree.right == null) {
			return i;
		}
		else if (left >= right) {
			return left;
		}
		else {
			return right;
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
		int[] remove1 = new int[length];
		for(int i=0;i<length;i++) {
			remove1[i]=Integer.parseInt(basket2[i]);
		}

		String[] basket3=br.readLine().split(" ");
		length=basket3.length;
		int[] insert2 = new int[length];
		for(int i=0;i<length;i++) {
			insert2[i]=Integer.parseInt(basket3[i]);
		}

		String[] basket4=br.readLine().split(" ");
		length=basket4.length;
		int[] remove2 = new int[length];
		for(int i=0;i<length;i++) {
			remove2[i]=Integer.parseInt(basket4[i]);
		}

		BSTree<Integer> tree = new BSTree<Integer>();
		for(int i=0;i<insert1.length;i++) {
			tree.insertByRecursion(insert1[i]);
		}
		System.out.println(tree.height());
		for(int i=0;i<remove1.length;i++) {
			tree.removeByRecursion(remove1[i]);
		}
		System.out.println(tree.height());
		
		BSTree<Integer> tree1 = new BSTree<Integer>();
		
		for(int i=0;i<insert2.length;i++) {
			tree1.insertByRecursion(insert2[i]);
		}
		System.out.println(tree1.height());
		for(int i=0;i<remove2.length;i++) {
			tree1.removeByRecursion(remove2[i]);
		}
		System.out.println(tree1.height());
		
		System.out.println("--------------------------------------");
		AVLTree tree2 = new AVLTree();
		
		for(int i=0;i<insert1.length;i++) {
			tree2.root=tree2.insert(tree2.root,insert1[i]);
		}
		System.out.println(tree2.tree_height(tree2.root));
		for(int i=0;i<remove1.length;i++) {
			tree2.delete(tree2.root,insert1[i]);
		}
		System.out.println(tree2.tree_height(tree2.root));
		
		AVLTree tree3 = new AVLTree();
		
		for(int i=0;i<insert2.length;i++) {
			tree3.root=tree3.insert(tree3.root,insert1[i]);

		}
		System.out.println(tree3.tree_height(tree3.root));

		for(int i=0;i<remove2.length;i++) {
			tree3.delete(tree3.root,insert1[i]);
		}
		System.out.println(tree3.tree_height(tree3.root));
	}
}
