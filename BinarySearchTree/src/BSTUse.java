
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

//================================ 
class four {
	int min;
	int max;
	boolean isBST;
	int height;
}

class pair<T, V> {
	public T first;
	public V second;
}

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

class DoubleNodeClass {

	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;
}
//=================================

public class BSTUse {

	public static void main(String[] args) {

		// BinaryTreeNode<Integer> root = takeInputLevelWise();
		// BinaryTreeNode<Integer> root2 = takeInputLevelWise();
		// printNodeFromK1ToK2( root, 6, 10 );
		// System.out.println(isBST2(root));
		// BSTToSortedLL(root);

//		BinarySearchTree bst = new BinarySearchTree();
//		bst.insertData(10);
//		bst.insertData(20);
//		bst.insertData(5);
//		bst.insertData(15);
//		bst.insertData(7);
//		bst.insertData(3);
//		bst.printTree();
//		bst.deleteData(10);
//		bst.printTree();
		// nodesSumToS(root, 15);
		// System.out.println(sizeOfLargestSubtree(root));
		// System.out.println( maxNodeInBetween( root, 3, 9) );
		// System.out.println(findMaxforN( root, 4 ));
		// System.out.println( checkBSTs( root1, root2 ) );
		// replaceWithLargerNodesSum ( root ) ;
		// System.out.println( sumOfNodesGreaterEqlK( root, 2 ) );

	}

//===========================================================================================	
//	 
//	 Check if a Binary Tree is BST
//	 Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree) or not. If yes, return true, return false otherwise.
//	 Duplicate elements should be in right subtree.
//	 Sample Input 1 :
//	 3 1 5 -1 2 -1 -1 -1 -1
//	 Sample Output 1 :
//	 true
//	 Sample Input 2 :
//	 5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
//	 Sample Output 2 :
//	 false

//	 //time complexity O(nlogn) to O(n^2) qki ek bar bol re max la min la fir
//	 // bol re check kr left bst right bst
	public static boolean isBSTBadSolution(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if (root.data <= leftMax) {
			return false;
		}
		if (root.data > rightMin) {
			return false;
		}

		boolean isLeftBST = isBSTBadSolution(root.left);
		boolean isRightBST = isBSTBadSolution(root.right);
		if (isLeftBST == true && isRightBST == true) {
			return true;
		} else {
			return false;
		}
	}

	private static int maximum(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return Integer.MIN_VALUE; // max value returmn krne se comparision false
		} // ni hoga kbi
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));

	}

	private static int minimum(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return Integer.MAX_VALUE; // max value returmn krne se comparision false
		} // ni hoga kbi

		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));

	}

	// ------time complexity of this solution is O(n)

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return isBSThelper(root).first;
	}

	// second pair class ka phla min hoga dusra max hoga
	public static pair<Boolean, pair<Integer, Integer>> isBSThelper(BinaryTreeNode<Integer> root) {

		if (root == null) {
			pair<Boolean, pair<Integer, Integer>> output = new pair<>();
			output.first = true;
			output.second = new pair<Integer, Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
		}

		pair<Boolean, pair<Integer, Integer>> leftOutput = isBSThelper(root.left);
		pair<Boolean, pair<Integer, Integer>> rightOutput = isBSThelper(root.right);

		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));

		boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first)
				&& leftOutput.first && rightOutput.first;

		pair<Boolean, pair<Integer, Integer>> output = new pair<>();
		output.first = isBST;
		output.second = new pair<Integer, Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;

	}

	// -------------------time complexity O(n)
	// best solution
	public static boolean isBST2(BinaryTreeNode<Integer> root) {
		return isBST2helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST2helper(BinaryTreeNode<Integer> root, int min, int max) {

		if (root == null) {
			return true;
		}
		if (root.data < min || root.data > max) {
			return false;
		}
		boolean isLeftOk = isBST2helper(root.left, min, root.data - 1);
		boolean isRightOk = isBST2helper(root.right, root.data, max);

		return (isLeftOk && isRightOk);
	}

//======================================================================================	
//	Code: Construct BST From Sorted Array
//	Given a sorted integer array A of size n which contains all unique elements. 
//	You need to construct a balanced BST from this input array. 
//	Return the root of constructed BST.
//	Note : If array size is even, take first mid as root.
//	Sample Input :
//	7
//	1 2 3 4 5 6 7
//	Sample Output :
//	4 2 1 3 6 5 7 
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {
		return helper(arr, 0, arr.length - 1);

	}

	private static BinaryTreeNode<Integer> helper(int[] arr, int si, int ei) {

		if (si > ei) {
			return null;
		}

		int mid = (si + ei) / 2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);

		root.left = helper(arr, si, mid - 1);
		root.right = helper(arr, mid + 1, ei);

		return root;
	}
	
//===================================================================================	
//	Path Sum Root to Leaf
//	Given a binary tree and a number k, print out all root to leaf paths 
//	where the sum of all nodes value is same as the given number k.
	// Sample Input 1 :
//	5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
//	13
//	Sample Output 1 :
//	5 6 2
//	5 7 1
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {

		if (root == null) {
			return;
		}
		String str = "";
		helper(root, k, str);
	}

	private static void helper(BinaryTreeNode<Integer> root, int k, String str) {

		if (root == null) {
			return;
		}
		str = str + root.data + " ";
		if (root.left == null && root.right == null) {
			if (k == root.data) {
				System.out.println(str);
				return;
			}
		}
		helper(root.left, k - root.data, str);
		helper(root.right, k - root.data, str);
	}

//================================================================================
}