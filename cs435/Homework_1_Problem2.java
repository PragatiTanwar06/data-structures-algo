package com.pragati.cs435;

/**
 * Created by pragati on 09/11/19.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


import java.util.*;

public class Homework_1_Problem2 {

    Node root=null;

    private void insert(int data){
        Node obj = new Node();
        obj.data = data;

        if(root == null){
            root = obj;
        }
        else{
            Queue<Node> queue = new LinkedList<>();

            queue.add(root);

            while(queue.size()!=0){

                Node parent = queue.poll();

                if(parent.left==null){
                    parent.left = obj;
                    return;
                }
                else if(parent.right==null){
                    parent.right = obj;
                    return;
                }

                queue.add(parent.left);
                queue.add(parent.right);
            }
        }
    }

    private ArrayList<Integer> toArray(){
        ArrayList array = new ArrayList();

        if(root==null)
            return null;

        else
        {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size()!=0){
                Node node = queue.poll();

                array.add(node.data);

                if(node.left!=null)
                    queue.add(node.left);

                if(node.right!=null)
                    queue.add(node.right);
            }
        }

        return array;
    }

    private void preOrder(Node node){

        if(node==null)
            return;

        System.out.print(node.data+" ");

        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node){

        if(node==null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.data+" ");
    }

    private boolean isBST(Node node, int min, int max){
        if(node==null)
            return true;

        if(node.data<min || node.data>max){
            return false;
        }

        return (isBST(node.left,min,node.data) && isBST(node.right,node.data,max));
    }

    private int numNodesInLookup(int key){
        if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return searchBST(root,key);

        else
            return searchLevelOrder(root, key);
    }

    private int searchLevelOrder(Node node, int key){
        Queue<Node> queue = new LinkedList<>();
        int count = 0;

        if(node==null)
            return 0;

        else{
            queue.add(node);

            while(queue.size()!=0){

                Node x = queue.poll();
                count++;

                if(x.data == key)
                    break;

                else{
                    queue.add(x.left);
                    queue.add(x.right);
                }
            }
        }
        return count;
    }

    private int searchBST(Node node, int key){

        if(node == null)
            return 0;

        if(node.data == key)
            return 1;

        if(node.data > key){
            return searchBST(node.left,key)+1;
        }
        else{
            return searchBST(node.right,key)+1;
        }

    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Homework_1_Problem2 solution = new Homework_1_Problem2();

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        for(int i=0;i<size;i++){
            solution.insert(sc.nextInt());
        }

        int operation = sc.nextInt();

        for(int i = 0;i<operation;i++){

            String str = sc.next();

            if(str.equals("toArray")){
                ArrayList array = solution.toArray();

                for(int j=0;j<array.size();j++){
                    System.out.print(array.get(j)+" ");
                }
                System.out.println();
            }

            else if(str.equals("isBST")){
                System.out.println(solution.isBST(solution.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
            }

            else if(str.equals("preOrder")){
                solution.preOrder(solution.root);
                System.out.println();
            }

            else if(str.equals("postOrder")){
                solution.postOrder(solution.root);
                System.out.println();
            }
            else if(str.contains("numNodesInLookup")){
                int key = sc.nextInt();

                System.out.println(solution.numNodesInLookup(key));
            }
        }
    }
}

class Node{
    Node left,right,parent;
    int data;
}