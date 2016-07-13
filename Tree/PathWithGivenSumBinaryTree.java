/* Given a tree ( Binary/ Binary Search) ,check whether the tree contains a path with the specified sum. If it exists, print the path*/
/* Currently the path printed is the reverse path . Just reverse it to get to path from top to bottom*/

package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PathWithGivenSumBinaryTree {
	int data;
	PathWithGivenSumBinaryTree left;
	PathWithGivenSumBinaryTree right;
	PathWithGivenSumBinaryTree(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
	public static PathWithGivenSumBinaryTree createBinaryTree(PathWithGivenSumBinaryTree root,int data)
	{
		PathWithGivenSumBinaryTree tree = new PathWithGivenSumBinaryTree(data);
		if(root==null)
		{	root = tree;
			return root;
		}
		Queue<PathWithGivenSumBinaryTree> queue = new LinkedList<PathWithGivenSumBinaryTree>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			PathWithGivenSumBinaryTree temp = queue.poll();
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
	public static ArrayList<PathWithGivenSumBinaryTree> checkPath(PathWithGivenSumBinaryTree root, ArrayList<PathWithGivenSumBinaryTree> resultPath,int sumValue)
	{
		if(root == null)
			return resultPath;
		if( root.left==null && root.right==null)
		{
			if(sumValue == root.data)
			{
				resultPath.add(root);
				return resultPath;
			}
			else 
				return resultPath;
		}
		if (root.left!=null)
		{
			checkPath(root.left,resultPath,sumValue-root.data);
			if(!resultPath.isEmpty())
			{
				resultPath.add(root);
				return resultPath;
			}
		}
		if (root.right!=null)
		{
			checkPath(root.right,resultPath,sumValue-root.data);
			if(!resultPath.isEmpty())
			{
				resultPath.add(root);
				return resultPath;
			}
		}
		return resultPath;
}
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	PathWithGivenSumBinaryTree root = null;
	ArrayList<PathWithGivenSumBinaryTree> path = new ArrayList<PathWithGivenSumBinaryTree>();
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
		System.out.println("Enter the sum value : ");
		int sumValue = input.nextInt();
		path=checkPath(root,path,sumValue);
		if (path.isEmpty())
			System.out.println("Path Does not exist with that sum");
		else
		{
			System.out.println("Path exists with that sum and the path is : ");
			Iterator<PathWithGivenSumBinaryTree> i = path.iterator();
			while(i.hasNext())
			{
				System.out.println(i.next().data+" ");
			}
		}
		}
	else
		System.out.println(" A tree cannot exist with 0 nodes ");
	}
}
