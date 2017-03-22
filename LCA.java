import java.util.Scanner;

/**
 * Created by CHEN on 2017/3/22.
 *
 * 求最近公共祖先
 */

class Node{
    Node left;
    Node right;
    int data;
    public Node(int data) {
        this.data=data;
    }
}
public class LCA {

    static Node getLCA(Node root,Node a,Node b) {

        if(root==null) {
            return null;
        }
        if(root==a||root==b) {
            return root;
        }
        Node left=getLCA(root.left,a,b);
        Node right=getLCA(root.right,a,b);
        if(left!=null&&right!=null) {
            return root;
        } else if(left!=null) {
            return left;
        } else if(right!=null) {
            return right;
        }

        return null;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        Node c=new Node(4);
        Node d=new Node(4);
        System.out.println(c.equals(d));
        root.left=a;
        a.left=b;
        a.right=c;
        c.left=d;
        Node t=getLCA(root,b,d);
        System.out.println(t.data);

    }
}

