package trees;

public class maxElemBinTree {
	int data;
	maxElemBinTree left;
	maxElemBinTree right;
	public static maxElemBinTree newnode(int data)
	{
		maxElemBinTree n = new maxElemBinTree();
		n.data = data;
		n.left=null;
		n.right = null;
		return n;
	}
	public static maxElemBinTree Insdata(int data, maxElemBinTree head)
	{
		maxElemBinTree temphead = head;
		maxElemBinTree n = maxElemBinTree.newnode(data);
		if (head == null)
		{
			head =n;
		}
		else
		{
			maxElemBinTree temp= null;
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
	public static void Inorder(maxElemBinTree head)
	{
		if(head == null)
			return;
		else
			maxElemBinTree.Inorder (head.left);
			System.out.print(head.data + " ");
			maxElemBinTree.Inorder (head.right);
	}
	public static void Preorder(maxElemBinTree head)
	{
		if(head == null)
			return;
		else
			System.out.print(head.data + " ");
			maxElemBinTree.Preorder (head.left);
			maxElemBinTree.Preorder (head.right);
	}
	public static void Postorder(maxElemBinTree head)
	{
		if(head == null)
			return;
		else
			maxElemBinTree.Postorder (head.left);
			maxElemBinTree.Postorder (head.right);
			System.out.print(head.data + " ");
			
	}
	public static int Max(maxElemBinTree head)
	{
		int root_val,left,right,max = -9999;
		if (head != null)
		{
			root_val=head.data;
			left = Max(head.left);
			right = Max(head.right);
			if( left > right)
				max = left;
			else
				max=right;
			if(root_val > max)
				max = root_val;
		}
		return max;
	}
	

	public static void main(String[] args)
	{
		maxElemBinTree head =null;
		head = Insdata(10,head);
		head = Insdata(15,head);
		head = Insdata(5,head);
		head = Insdata(7,head);
		head = Insdata(19,head);
		head = Insdata(20,head);
		head = Insdata(-1,head);
		head = Insdata(21,head);
		/*System.out.println("Inorder Traversal");
		Inorder (head);
		System.out.println("Postorder Traversal");
		Postorder (head);
		System.out.println("Preorder Traversal");
		Preorder(head);*/
		System.out.println("Max : " + Max(head));
	}
}

