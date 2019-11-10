package com.pragati.cs435;

/**
 * Created by pragati on 09/11/19.
 */
import java.util.*;

public class Homework_1_Problem1 {

    ArrayList<Integer>  array = new ArrayList<>();

    private int size(){
        return this.array.size();
    }

    private void insert(int x){
        array.add(x);

        int n = array.size()-1;
        maxDownHeap(n);
    }

    private int maxLookup(){
        return array.get(0);
    }

    private void maxDownHeap(int n){

        int parent = (n-1)/2;

        if(n==0)
            return;

        if(array.get(parent)<array.get(n)){
            int temp = array.get(parent);

            array.set(parent,array.get(n));
            array.set(n, temp);
        }

        if(parent==0)
            return;
        maxDownHeap(parent);
    }

    private void delete(int x){
        array.set(x,array.get(array.size()-1));
        array.remove(array.size()-1);

        heapify(x);
    }

    private void extractMax(){
        array.set(0,array.get(array.size()-1));
        array.remove(array.size()-1);
        heapify(0);
    }

    private void heapify(int parent){
        int left = parent*2 + 1;
        int right = parent*2 + 2;

        int size = array.size()-1;
        int max = left;

        if(left > size)
            return;

        else if(right<size && array.get(left)<array.get(right)){
            max = right;
        }

        if(array.get(max)>array.get(parent)){
            int temp = array.get(max);
            array.set(max,array.get(parent));
            array.set(parent,temp);
        }

        heapify(max);
    }


    public static void main(String[] args) {
        // write your code here

        Homework_1_Problem1 obj = new Homework_1_Problem1();

        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        String action;

        while(sc.hasNext()){
            action = sc.next();

            if(action.equals("size")){
                System.out.println(obj.size());
            }
            else if(action.contains("insert")){
                obj.insert(sc.nextInt());
            }
            else if(action.contains("maxLookup")){
                System.out.println(obj.maxLookup());
            }
            else if(action.contains("extractMax")){
                obj.extractMax();
            }
            else if(action.contains("delete")){
                obj.delete(sc.nextInt());
            }
        }
    }
}
