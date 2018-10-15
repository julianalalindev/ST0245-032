
/**
 * Write a description of class Lab4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinaryTree {

    public class Node {

        public Node left;
        public Node right;
        public int data;

        public Node (int data) {
            this.data=data;
        }
    }

    public Node root;

    public void buildTree (int [] preOrder) {
        root=new Node(preOrder[0]);
        for(int x=1; x<preOrder.length; x++) {
            insert(root, preOrder[x]);
        }
    }

    public void insert (Node node, int data) {
        if(data<node.data && node.left==null) {
            node.left=new Node(data);
        } else if(data<node.data) {
            insert(node.left,data);
        } else if(data>node.data && node.right==null) {
            node.right=new Node(data);
        } else if(data>node.data) {
            insert(node.right,data);
        }
    }

    public void preOrder(Node node) {
        if(node!=null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void posOrder(Node node) {
        if(node!=null) {
           posOrder(node.left);
           posOrder(node.right);
           System.out.println(node.data);
        }
    }
    
    public void exercise21 (int [] input) {
        buildTree(input);
        System.out.println("PosOrder");
        posOrder(root);
        System.out.println();
    }

    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        BinaryTree testing = new BinaryTree();
        testing.exercise21(test);
    }
}
