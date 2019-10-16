package com.pragati.karumanchi_concepts;

/**
 * Created by pragati on 10/09/19.
 */
public class LinkedList {

    LinkedNode head;
    private int length;

    public synchronized void insertAtBegin(LinkedNode node){

        node.setNext(head);
        head = node;
        length++;
    }

    public synchronized void insertAtEnd(LinkedNode node){

        LinkedNode p;
        if(head==null){
            head = node;
        }
        else{
            for(p = head;(p.getNext()!=null);p=p.getNext() );
            p.setNext(node);
        }
    }

    public synchronized void insert(int data,int position){
        LinkedNode node = new LinkedNode();
        node.setData(data);

        if(position==0){
            node.setNext(head);
            head = node;
        }
        else{
            LinkedNode temp = head;

            for(int i=1;i<position;i++){
                temp = temp.getNext();

            }

            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        length++;
    }

    public void display(){

        for(LinkedNode i = head;i!=null; i=i.getNext() ){
            System.out.println(i.getData()+" ");
        }
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insert(12,0);
        linkedList.insert(13,1);
        linkedList.insert(14,2);
        linkedList.insert(15,3);

        LinkedNode node = new LinkedNode();
        node.setData(16);
        linkedList.insertAtBegin(node);

        LinkedNode node2 = new LinkedNode();
        node2.setData(17);
        linkedList.insertAtEnd(node2);

        linkedList.display();
    }
}
