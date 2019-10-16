package com.pragati.leetcode;

import java.util.ArrayList;

/**
 * Created by pragati on 13/10/19.
 */
public class MaxHeap {

    ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }
    public int size() {
        return heap.size();
    }
    public int maxLookup() {
        return heap.get(0);
    }
    public void extractMax() {

        heap.set(0,size()-1);


    }
    public void insert(int data) {
        heap.add(data);
        int n = size();

        heapify(n);
    }
    public void remove(int index) {

    }
    private void heapify(int node) {

        int parent = node/2-1;
        int leftChild = parent*2+1;
        int rightChild = parent*2+2;
        int max =leftChild;

        if(parent<0)
            return;

        if(rightChild<size() && heap.get(max)<heap.get(rightChild)) {
            max = rightChild;
        }
        if(heap.get(parent) < heap.get(max)){
            int temp = heap.get(parent);
            heap.set(parent,heap.get(max));
            heap.set(max,temp);
        }

        if(max!=parent)
            heapify((parent+1));
    }

    public static void main(String[] args){

        MaxHeap obj = new MaxHeap();
        obj.insert(1);
        System.out.println(obj.maxLookup());
        obj.insert(2);
        System.out.println(obj.maxLookup());
        obj.insert(3);
        System.out.println(obj.maxLookup());
        obj.insert(4);
        System.out.println(obj.maxLookup());
    }
}
