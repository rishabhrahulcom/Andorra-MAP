package com.rishabhrahul.map.EPI;

import java.util.List;

public class SLinkedList {
    static class SNode {
        int data;
        SNode next;
        public SNode(int data) {
            this.data = data;
            this.next = null;
        }
        SNode(int data, SNode next) {
            this.data = data;
            this.next = next;
        }
    }
    SNode runner;
    SNode head;
    SNode tail;
    int size =1;
    public SLinkedList(List<Integer> list) {
        head = new SNode(list.get(0));
        runner = head;
        // using stream api
        while (size< list.size() ) {
            runner.next  = new SNode(list.get(size));
            tail = runner;
            runner = runner.next;
            size++;
        }



    }
//          [[Head, size =1]->[, size =2 ]->[, size =3]->[, size =4]->[, size =5]->null]
SNode deleteByIndex(SNode myHead, int Index){
     if( Index == 1 ){ return this.head = myHead.next;

     };
     if(Index > size) return myHead;
     SNode current =myHead;
     SNode previous = current;
     int sizeTemp = 1;
     while(sizeTemp < Index){
        previous = current;
         current = current.next;
         sizeTemp++;
     }
     previous.next = current.next;
        return myHead;
    }
void deleteByValue(SNode myHead, int Value){
        // This thing would be basic assertions. and then we can proceed with linear search, finding the current ->that ele
    // previous.next -> current.next

    }
    void print(){
        SNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    SNode instertAtIndex(int val, int index){
        SNode current = this.head;
        int indexFinder = 1;
        //
        if(current == null ) return new SNode(val);

        if(index == 1 ) {
            SNode temp = new SNode(val);
            temp.next = current;
            head = temp;
            return head;
        }
        if(index > this.size) {
            return null;
        }
        while (indexFinder < index-1) { // we want previous one
            current = current.next;
            indexFinder++;
        }
        SNode SNodeToBeInserted = new SNode(val);
        SNodeToBeInserted.next = current.next;
        current.next = SNodeToBeInserted;
        return head;
    }
SNode replaceAtIndex(int val, int index){
        SNode current = this.head;
        int indexFinder = 1;
        //previous index
        SNode previous = null;
        while (indexFinder < index) {
            previous = current;
            current = current.next;
            indexFinder++;
        }
        SNode temp = new SNode(val);
//        [temp next]
//      [previous.next] -> [current] -> [current.next]

        temp.next = current.next;
        previous.next = temp;


        return head;

    }
    SNode insertAtHead(int Value){

        SNode temp = new SNode(Value);
        temp.next = this.head;
        head = temp;
        return temp;
    }

    public static void main(String[] args) {
        SLinkedList list = new SLinkedList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.print();
        System.out.println("");
        list.deleteByIndex(list.head,4);
        list.instertAtIndex(80,4);
        list.print();
        list.replaceAtIndex(99,4);
        System.out.println("");
        list.print();

    }


}
