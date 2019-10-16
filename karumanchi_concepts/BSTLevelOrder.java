package com.pragati.karumanchi_concepts;

import java.util.Queue;

/**
 * Created by pragati on 15/09/19.
 */
public class BSTLevelOrder {

    Node root;
    public void levelOrder(){
        Queue<Node> queue = new java.util.LinkedList<Node>();

        queue.add(root);
        while(!queue.isEmpty()){

            System.out.print(queue.peek().data+" ");

            Node temp = queue.poll();

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);

        }
    }

    public static void main(String[] args){
        BSTLevelOrder obj = new BSTLevelOrder();
        obj.root = new Node(1);
        obj.root.left = new Node(2);
        obj.root.right = new Node(3);
        obj.root.left.left = new Node(4);
        obj.root.left.right = new Node(5);
        obj.root.right.left = new Node(6);
        obj.root.right.right = new Node(7);

        obj.levelOrder();
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
