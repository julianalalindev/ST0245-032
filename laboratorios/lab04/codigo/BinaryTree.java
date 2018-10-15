public class BinaryTree {
    public Node root;

    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }

    public int maxheight()
    {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
    
    public static void whoIsYourGrandma(Node grandson){
        if(grandson!=null){
            if(grandson.left.left!= null){
                System.out.println("Your grandma is: "+ grandson.left.left);
            }else{
                System.out.println("We do not know who your grandma is. Sorry");
            }
        }
    }

    
}