package com.pragati.karumanchi_concepts;

/**
 * Created by pragati on 14/09/19.
 */
public class UnrolledLinkedList {
    private UnrolledNode head;
    private UnrolledNode tail;
    private int capacity = 5;

    public void insert(int data){
        //If we are implementing first element in first node
        if(head==null){
            UnrolledNode node = new UnrolledNode(capacity);
            node.array[0] = data;
            head = node;
            tail = node;
            node.noElements++;
        }
        //When we have not reached the threshold, implementing in the last(tail) node.
        else if(tail.noElements < ((capacity/2)+1)){
            tail.array[tail.noElements] = data;
            tail.noElements++;
        }
        //When we have reached threshold, create new node
        else{
            UnrolledNode node = new UnrolledNode(capacity);
            tail.next = node;

            node.array[0] = data;
            tail = node;
            tail.noElements++;
        }
    }

    public void display(){

        for(UnrolledNode node = head; node != null ; node=node.next){

            for(int i:node.array){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        UnrolledLinkedList ULL = new UnrolledLinkedList();
        ULL.insert(12);
        ULL.insert(13);
        ULL.insert(14);
        ULL.insert(15);
        ULL.insert(16);
        ULL.insert(17);
        ULL.insert(18);

        ULL.display();
    }
}
