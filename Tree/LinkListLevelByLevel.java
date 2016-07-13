package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkListLevelByLevel {
	public static ArrayList<LinkedList<TreeNode>> linkListOfLevel(TreeNode head)
	{
		ArrayList<LinkedList<TreeNode>> result= new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current= new LinkedList<TreeNode>();
		if(head !=null)
		{
			current.add(head);
		}
		while(current.size()>0)
		{
			result.add(current);
			LinkedList<TreeNode> previousLevel = current;
			current = new LinkedList<TreeNode>();
			for ( TreeNode parent : previousLevel)
			{
				if(parent.left!=null)
					current.add(parent.left);
				if(parent.right!=null)
					current.add(parent.right);
			}
		}
		return result;
	}
	public static void main(String[] args)
    {
            TreeNode head= null;
            //head = Node.InsertNewNode(5,head);
            head = TreeNode.Insdata(7,head);
            head = TreeNode.Insdata(10, head);
            head = TreeNode.Insdata(15, head);
            head = TreeNode.Insdata(5, head);
            head = TreeNode.Insdata(7, head);
            head = TreeNode.Insdata(19, head);
            head = TreeNode.Insdata(20, head);
            head = TreeNode.Insdata(-1, head);
            int depth =0;
            ArrayList<LinkedList<TreeNode>> result = linkListOfLevel(head);
            for ( LinkedList<TreeNode> al : result)
            {
            	depth++;
            	Iterator<TreeNode> i = al.iterator();
            	System.out.print("Nodes at level "+ depth + " : ");
            	while (i.hasNext())
            	{
            		System.out.print(((TreeNode)i.next()).data+ " ");
            	}
            	System.out.println("");
            }
    }

}
