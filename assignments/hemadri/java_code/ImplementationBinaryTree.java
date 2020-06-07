public class ImplementationBinaryTree 
{
    private Node root;
    ImplementationBinaryTree()
    {
        root = null;
    }
    static class Node
    {
        int value;
        Node left;
        Node right;
        Node(int value)
        {
            this.value = value;
            left = null;
            right = null;        
        }
        public void displayData()
        {
            System.out.print(value + " ");
        }
    }
    public void insert(int i)
    {
        root = insert(root, i);
    }
    public Node insert(Node node, int value)
    {
        if(node == null){
            return new Node(value);
        }
        if(value < node.value)
        {
            node.left = insert(node.left, value);
        }
        else if(value > node.value)
        {
            node.right = insert(node.right, value);
        }
        return node;
    }
    public Node find(int searchedValue)
    {
        Node current = root;
        while(current.value != searchedValue){
            if(searchedValue < current.value)
                // Move to the left if searched value is less
                current = current.left;
            else
                // Move to the right if searched value is >=
                current = current.right;
            if(current == null){
                return null;
            }
        }
       return current;
    }
    public void binary(Node node){
        if(node != null){
            node.displayData();
            binary(node.left);
            binary(node.right);
        }
    }
    public static void main(String[] args) {
        ImplementationBinaryTree bst = new ImplementationBinaryTree();
        for(int j=0;j<args.length;j++)
        {
        	bst.insert(Integer.parseInt(args[j]));
        } 
        System.out.println("binary tree output");
        bst.binary(bst.root);
      
    }
}