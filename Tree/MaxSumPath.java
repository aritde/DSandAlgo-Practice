package trees;

public class MaxSumPath {
	int data;
	MaxSumPath left;
	MaxSumPath right;
	public static MaxSumPath newnode(int data)
	{
		MaxSumPath n = new MaxSumPath();
		n.data = data;
		n.left=null;
		n.right = null;
		return n;
	}
	public static boolean maxSumPath(MaxSumPath head, int sum)
	{
		if (head == null)
			return false;
		if ( head.left !=null && head.right!=null )
		{
			if(head.data == sum)
				return true;
			else
				return false;
		}
		int remSum = sum - head.data;
		if ( head.left!=null)
			return maxSumPath(head.left, remSum);
		if ( head.right!=null)
			return maxSumPath(head.right, remSum);
	return false;
	}
	public static MaxSumPath Insdata(int data, MaxSumPath head)
	{
		MaxSumPath temphead = head;
		MaxSumPath n = MaxSumPath.newnode(data);
		if (head == null)
		{
			head =n;
		}
		else
		{
			MaxSumPath temp= null;
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
	public static void main(String[] args)
	{
		MaxSumPath head =null;
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
		System.out.println("Max : " + maxSumPath(head,11));
	}

}
