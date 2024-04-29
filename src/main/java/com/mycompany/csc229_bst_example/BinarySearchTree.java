package com.mycompany.csc229_bst_example;
/**
 *
 * This class handles the Binary Search Tree Methods
 *
 * @author MoaathAlrajab and Ken Kohlhof
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        //checks if root is null
        if(root == null){
            return;
        }
        //Recursive call to get the left of the root
        doInOrder(root.getLeft());
        //Prints the data of the root plus a space
        System.out.print(root.getData() + " ");
        //Recursive call to get the right of the root
        doInOrder(root.getRight());


        // ToDo 1: complete InOrder Traversal 
    }
        public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal . 
    }

    private void doPreOrder(BstNode root){
        //Checks if root is null
        if(root == null){
            return;
        }
        //Prints the data of the root plus a space
        System.out.print(root.getData() + " ");
        //recursive call to get the left of the root
        doPreOrder(root.getLeft());
        //recursive call to get the right of the root
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        return getHeight(this.root);

        // ToDo 3: Find the height of a tree
    }

    private Integer getHeight(BstNode root){
        //Checks if root is null
        if(root == null){
            return -1;
        }
        //Sets leftHeight as the node variable to the left
        int leftHeight = getHeight(root.getLeft());
        //Sets rightHeight as the node variable to the right
        int rightHeight = getHeight(root.getRight());

        //Returns leftHeight and rightHeight plus one
        return Math.max(leftHeight, rightHeight) + 1;
    }

    

    public int getDepth(BstNode node) {
        //Checks if root is null
        if (node == null){
            return -1;
        }
        //Sets leftDepth as recursive call passing the value of the node variable to the left
        int leftDepth = getDepth(node.getLeft());
        //Sets rightDepth as recursive call passing the value of the node variable to the right
        int rightDepth = getDepth(node.getRight());

        //Returns leftDepth and RightDepth plus one
        return Math.max(leftDepth, rightDepth) + 1;
        //ToDo 4: complete getDepth of a node
    }

    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }

    public void print(String prefix, BstNode node, boolean isLeft){
        //Checks if node is null
        if(node != null){
            //Prints prefix and node
            System.out.println(prefix + (isLeft ? "|__  " : "\\__") + node.getData());
            //prints left
            print(prefix + (isLeft ? "|  " : "   "), node.getLeft(), true);
            //prints right
            print(prefix + (isLeft ? "|  " : "   "), node.getRight(), false);
        }
    }


}
