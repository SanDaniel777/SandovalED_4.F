package com.example.integradora.structures;

public class SinglyLinkedList<T> {
    public Node<T> head; 

    public void add(T data) {
        Node<T> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = nuevo;
    }

   
}