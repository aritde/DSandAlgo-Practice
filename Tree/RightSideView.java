package trees;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RightSideView {
	int data;
	RightSideView left;
	RightSideView right;
	RightSideView(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
	public static RightSideView createBinaryTree(RightSideView root,int data)
	{
		RightSideView tree = new RightSideView(data);
		if(root==null)
		{	root = tree;
			return root;
		}
		Queue<RightSideView> queue = new LinkedList<RightSideView>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			RightSideView temp = queue.poll();
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
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		RightSideView root = null;
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
			System.out.println("Right Side traversal :");
			ArrayList<Integer> arr= rightSideView(root);
			Iterator<Integer> i= arr.iterator();
			while(i.hasNext())
			System.out.print(i.next() + " ");
		}
		else
			System.out.println(" A tree cannot exist with 0 nodes ");

	}

	public static ArrayList<Integer> rightSideView(RightSideView root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        rightView(root, result, 0);
	        return result;
	    }

	    public static void rightView(RightSideView curr, ArrayList<Integer> result, int currDepth){
	        if(curr == null){
	            return;
	        }
	        if(currDepth == result.size()){
	            result.add(curr.data);
	        }

	        rightView(curr.right, result, currDepth + 1);
	        rightView(curr.left, result, currDepth + 1);

	    }
	}


