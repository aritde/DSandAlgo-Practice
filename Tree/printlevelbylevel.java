package trees;
import java.io.*;
import java.util.*;
class printlevelbylevel
{
        int data;
        printlevelbylevel left;
        printlevelbylevel right;
        printlevelbylevel parent;
        public printlevelbylevel(int data)
        {
                this.data=data;
        }
        public void leftchildren(printlevelbylevel left)
        {
                this.left=left;
                if(left!=null)
                        left.parent=this;
        }
        public void rightchildren(printlevelbylevel right)
        {
                this.right=right;
                if(right!=null)
                        right.parent=this;
        }
        public static printlevelbylevel Minimal_BST(int []arr,int start,int end)
        {
                int mid=0;
                if(end<start)
                        return null;
                else
                {
                        mid=(start+end)/2;
                        printlevelbylevel n= new printlevelbylevel(arr[mid]);
                        n.leftchildren(Minimal_BST(arr,start,mid-1));
                        n.rightchildren(Minimal_BST(arr,mid+1,end));
                        return n;
                }
        }
        public static printlevelbylevel newnode(int data)
        {
                printlevelbylevel n=new printlevelbylevel(data);
                //n.data=data;
                n.left=null;
                n.right=null;
                return n;
        }
        public static printlevelbylevel InsertNode(int data, printlevelbylevel head)
        {
                printlevelbylevel temphead=head;
                printlevelbylevel n=printlevelbylevel.newnode(data);
                if (head==null)
                {
                        head=n;
                }
                else
                {
                        printlevelbylevel temp=null;
                        while(temphead!=null)
                        {
                                temp=temphead;
                                if(temphead.data>data)
                                        temphead=temphead.left;
                                else
                                        temphead=temphead.right;
                        }
                        if(temp.data>data)
                                temp.left=n;
                        else
                                temp.right=n;
                }
                return head;
        }
        public static void BFS_Traversal(printlevelbylevel head)
        {
                Queue<printlevelbylevel> q=new LinkedList<printlevelbylevel>();
                q.add(head);
                q.add(null);
                while(q.size()!=0)
                {
                        head=q.poll();
                        if(head==null)
                        {
                                if(q.size()!=0)
                                {
                                        System.out.println();
                                        q.add(null);
                                }
                        }
                        else
                        {
                                System.out.print(head.data + "   ");
                                if(head.left!=null)

                                	 q.add(head.left);
                                if(head.right!=null)
                                        q.add(head.right);
                        }

                }
        }



        public static void main(String[] args)
        {
                int[] arr={1,2,3,4,5,6,7,8,9,10};
                printlevelbylevel head=null;
                int i;
                System.out.println("Creating a normal Binary Search Tree :");
                for(i=1;i<10;i++)
                {
                        head=printlevelbylevel.InsertNode(arr[i],head);
                }
                System.out.println("Printing the normal Binary Search Tree Level by Level :");
                BFS_Traversal(head);
                head=null;
                System.out.println("Creating a minimal height Binary Search Tree :");
                head=Minimal_BST(arr,0,9);
                System.out.println("Printing the minimal height Binary Search Tree Level by Level :");
                BFS_Traversal(head);
        }
}
