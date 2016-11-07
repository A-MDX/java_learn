package composite;

/**
 * Created by A-mdx on 2016/11/7.
 */
public class Tree {
    
    TreeNode root = null;
    
    public Tree(String name){
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("Apple");
        TreeNode node1 = new TreeNode("a");
        TreeNode node2 = new TreeNode("b");
        
        node1.add(node2);
        tree.root.add(node1);

        System.out.println("build the tree finished!");
        
    }
    
}
