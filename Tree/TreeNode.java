package trees;



public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public static TreeNode newnode(int data)
	{
		TreeNode n = new TreeNode();
		n.data = data;
		n.left=null;
		n.right = null;
		return n;
	}
	public static TreeNode Insdata(int data, TreeNode head)
	{
		TreeNode temphead = head;
		TreeNode n = TreeNode.newnode(data);
		if (head == null)
		{
			head =n;
		}
		else
		{
			TreeNode temp= null;
			while(temphead!=null)
			{
				temp=temphead;
				if(temphead.data > n.data)
					temphead = temphead.left;
				else
					temphead = temphead.right;
			}
			if (temp.data > n.data)
			{
				temp.left = n;
			}
			else
				temp.right =n;
		}
		return head;
	}
	public static void Inorder(TreeNode head)
	{
		if(head == null)
			return;
		else
			TreeNode.Inorder (head.left);
			System.out.print(head.data + " ");
			TreeNode.Inorder (head.right);
	}
	public static void Preorder(TreeNode head)
	{
		if(head == null)
			return;
		else
			System.out.print(head.data + " ");
			TreeNode.Preorder (head.left);
			TreeNode.Preorder (head.right);
	}
	public static void Postorder(TreeNode head)
	{
		if(head == null)
			return;
		else
			TreeNode.Postorder (head.left);
			TreeNode.Postorder (head.right);
			System.out.print(head.data + " ");
			
	}
	public static void main(String[] args)
	{
		TreeNode head =null;
		head = Insdata(10,head);
		head = Insdata(15,head);
		head = Insdata(5,head);
		head = Insdata(7,head);
		head = Insdata(19,head);
		head = Insdata(20,head);
		head = Insdata(-1,head);
		head = Insdata(21,head);
		System.out.println("Inorder Traversal");
		Inorder (head);
		System.out.println("Postorder Traversal");
		Postorder (head);
		System.out.println("Preorder Traversal");
		Preorder(head);
	}
	
}
