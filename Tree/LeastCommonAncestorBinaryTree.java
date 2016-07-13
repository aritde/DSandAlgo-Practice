package trees;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeastCommonAncestorBinaryTree {
		int data;
		LeastCommonAncestorBinaryTree left;
		LeastCommonAncestorBinaryTree right;
		LeastCommonAncestorBinaryTree(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
		public static LeastCommonAncestorBinaryTree createBinaryTree(LeastCommonAncestorBinaryTree root,int data)
		{
			LeastCommonAncestorBinaryTree tree = new LeastCommonAncestorBinaryTree(data);
			if(root==null)
			{	root = tree;
				return root;
			}
			Queue<LeastCommonAncestorBinaryTree> queue = new LinkedList<LeastCommonAncestorBinaryTree>();
			queue.add(root);
			while(!queue.isEmpty())
			{
				LeastCommonAncestorBinaryTree temp = queue.poll();
				if(temp.left==null)
				{
					temp.left=tree;
					return root;
				}
				else if(temp.right==null)
				{
					temp.right=tree;
					return root;
				}
				else
				{
					queue.add(root.left);
					queue.add(root.right);
				}
			}
			return root;
		}
		public static LeastCommonAncestorBinaryTree lcaBin(LeastCommonAncestorBinaryTree root,LeastCommonAncestorBinaryTree a,LeastCommonAncestorBinaryTree b)
		{
			if (root == null)
				return null;
			if(root.data == a.data || root.data == b.data)
				return root;
			LeastCommonAncestorBinaryTree leftSubTree=lcaBin(root.left,a,b);
			LeastCommonAncestorBinaryTree rightSubTree=lcaBin(root.right,a,b);
			if(leftSubTree != null && rightSubTree != null)
				return root;
			if (leftSubTree == null && rightSubTree == null)
				return null;
			return leftSubTree==null ? rightSubTree : leftSubTree;
		}
		public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		LeastCommonAncestorBinaryTree root = null;
		LeastCommonAncestorBinaryTree a = new LeastCommonAncestorBinaryTree(2);
		LeastCommonAncestorBinaryTree b= new LeastCommonAncestorBinaryTree(5);
		ArrayList<LeastCommonAncestorBinaryTree> path = new ArrayList<LeastCommonAncestorBinaryTree>();
		System.out.println("How many nodes do you want in the tree : ");
		int noOfNodes = input.nextInt();
		int countOfNodes = 0;
		if (noOfNodes > 0 )
		{
			while(countOfNodes < noOfNodes)
			{
				System.out.println("Enter the node : ");
				int data = input.nextInt();
				root = createBinaryTree(root,data);
				countOfNodes++;
			}
			LeastCommonAncestorBinaryTree result = lcaBin(root,a,b);
			System.out.println(result.data);
		}
		else
			System.out.println(" A tree cannot exist with 0 nodes ");
		}
	}
