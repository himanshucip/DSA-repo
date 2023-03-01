package com.company.trees;

import com.sun.source.tree.Tree;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    BinaryTree(){
        this.root=null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.setLeft(second);
        first.setRight(third);
        second.setLeft(fourth);
        second.setRight(fifth);
    }

    public void preOrder(TreeNode root){
        TreeNode temp = root;
        if(temp == null){
            return;
        }
        System.out.println(temp.getData());
        preOrder(temp.getLeft());
        preOrder(temp.getRight());

    }


    public void preOrderIterative(TreeNode root){
        TreeNode temp = root;
        if(temp == null){
            System.out.println("Empty");
            return;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode d = st.pop();
            System.out.println(d.getData());

            if(d.getRight() != null){
                st.push(d.getRight());
            }
            if(d.getLeft() != null){
                st.push(d.getLeft());
            }

        }
    }

    public void postOrderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;

        while(current!=null || !st.isEmpty()){
            if(current != null){
                st.push(current);
                current = current.getLeft();
            }
            else{
                TreeNode temp = st.peek().getRight();
                if(temp == null){
                    temp = st.pop();
                    System.out.println(temp.getData());
                    while(!st.isEmpty() && st.peek().getRight() == temp){

                        temp = st.pop();
                        System.out.println(temp.getData());
                    }
                }
                else{
                    current = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree();
        b1.createBinaryTree();
//        b1.preOrder(b1.root);
        b1.postOrderIterative(b1.root);
    }
}
