package com.rishabhrahul.map.EPI;

public class DLinkedList {
    static class DNode {
        int data;
        DNode next;
        DNode previous;
        public DNode(int data ) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
        DNode(int data, DNode next, DNode previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

    }
    DNode runner;
    DNode head;
    DNode tail;
    int size =1;

}
