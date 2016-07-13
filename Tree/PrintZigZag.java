/*Level Order Traversal*/
/*Creating a binary tree*/
package trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class PrintZigZag {
	int data;
	PrintZigZag left;
	PrintZigZag right;
	PrintZigZag(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
	public static PrintZigZag createBinaryTree(PrintZigZag root,int data)
	{
		PrintZigZag tree = new PrintZigZag(data);
		if(root==null)
		{	root = tree;
			return root;
		}
		Queue<PrintZigZag> queue = new LinkedList<PrintZigZag>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			PrintZigZag temp = queue.poll();
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
	public static void LevelOrderTraversal(PrintZigZag root)
	{
		if (root == null)
		{	System.out.println("No tree to traverse!");
		    return;
		}
		Queue<PrintZigZag> queue = new LinkedList<PrintZigZag>();
		PrintZigZag dummy= new PrintZigZag(-1);
		queue.add(root);
		queue.add(dummy);
		while(!queue.isEmpty())
		{
			PrintZigZag temp=queue.poll();
			if (temp == dummy)
			{
				if(!queue.isEmpty()) //Watchout!!
					queue.add(dummy);
				System.out.println("");
			}
			else
			{
				System.out.print(temp.data + "  ");
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}			
					
		}
		
	}
	public static void ZigZagTraversal(PrintZigZag root)
	{
		if (root == null)
		{	System.out.println("No tree to traverse!");
		    return;
		}
		Stack<PrintZigZag> s1=new Stack<PrintZigZag>();
		Stack<PrintZigZag> s2=new Stack<PrintZigZag>();
		boolean marker = true;
		s1.push(root);
		while(!s1.isEmpty())
		{
			PrintZigZag temp = s1.pop();
			System.out.print(temp.data + " ");
			if(marker)
			{
				if(temp.left!=null)
					s2.push(temp.left);
				if(temp.right!=null)
					s2.push(temp.right);
			}
			else
			{
				if(temp.right!=null)
					s2.push(temp.right);
				if(temp.left!=null)
					s2.push(temp.left);
			}
			if(s1.empty())
			{
				marker = false;
				Stack<PrintZigZag> tempStack = s1;
				s1=s2;
				s2=tempStack;
			}
		}
		
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		PrintZigZag root = null;
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
			System.out.println("Level Order Traversal : ");
			LevelOrderTraversal(root);
			System.out.println("Zig Zag traversal :");
			ZigZagTraversal(root);
		}
		else
			System.out.println(" A tree cannot exist with 0 nodes ");

	}
}
