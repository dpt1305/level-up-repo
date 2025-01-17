package com.example.bt9;

public class IterationLinkedList {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node root;
        public LinkedList(int value) {
            this.root = new Node(value);
        }

        public void add(int value) {
            Node newNode = new Node(value);
            Node current = root;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void print() {
            Node current = root;
            while(current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }

        public Node printWithRecursive(Node current)  {
            if(current == null) {
                System.out.println("Run out of this linked list.");
                return null;
            }

            System.out.println(current.value);
            return printWithRecursive(current.next);
        }

        public void reverse() {
            Node current = root;
            Node prev = null;
            Node next = null;
            while(current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            root = prev;


            // 1 2 3 4 5
            // next = 2, 3
            // current = 1, null
            // prev = 1, null
            // current = 2,3 

            // next = 3, 4
            // current = 2, (1, null)
            // prev = 2, (1, null)
            // current = 3, 4
        }
    }

    // iteration a linked list
    public static void iterationLinkedList() {
        LinkedList linkedList = createLinkedList();
        linkedList.print();
        linkedList.printWithRecursive(linkedList.root);
    }

    // reverse a linked list
    public static void reverseLinkedList() {
        LinkedList linkedList = createLinkedList();
        linkedList.print();

        System.out.println("Reversed linked list:");
        linkedList.reverse();
        linkedList.print();
    }

    public static LinkedList createLinkedList() {
        LinkedList linkedList1 = new LinkedList(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);
        return linkedList1;
    }
}

