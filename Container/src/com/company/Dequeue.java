package com.company;

import java.util.Scanner;

class Dequeue {
    private final static int DEFSIZE = 16;
    private int[] array;
    private int size, head, tail;

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }
    private int backward(int index) {
        return --index >= 0 ? index : array.length - 1;
    }
    public Dequeue(int size) {
        array = new int[size];
        clear();
    }
    public void clear() {
        size = head = 0;
        tail = array.length - 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Dequeue() {
        this(DEFSIZE);
    }
    public int length() {
        return size;
    }
    public void pushFront(int p) {
        array[head=backward(head)] = p;
        size += 1;
    }
    public void pushBack(int p) {
        array[tail=forward(tail)] = p;
        size += 1;
    }
    public int popFront() throws Exception{
        int p = front();
        head = forward(head);
        size -= 1;
        return p;
    }
    public int popBack() throws Exception{
        int p = back();
        tail = backward(tail);
        size -= 1;
        return p;
    }
    public int front() throws Exception {
        if (isEmpty()) throw new Exception();
        return array[head];
    }
    public int back() throws Exception {
        if (isEmpty()) throw new Exception();
        return array[tail];
    }
    public void printHeadToTail() throws Exception {
        if (isEmpty()) throw new Exception();
        for (int i = head; i <= tail; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printTallToHead() throws Exception {
        if (isEmpty()) throw new Exception();
        for (int i = tail; i >= head; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Dequeue d = new Dequeue(5);
        Scanner scanner = new Scanner(System.in);
        int act;

        while (true) {
            act = scanner.nextInt();
            switch (act) {
                case 0:
                    System.out.println("Queue is " + (d.isEmpty() ?
                        "empty" :
                        "not empty"));
                    break;
                case 1:
                    d.pushFront(scanner.nextInt());
                    break;
                case 2:
                    d.pushBack(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(d.popFront());
                    break;
                case 4:
                    System.out.println(d.popBack());
                    break;
                case 5:
                    System.out.println("Front = " + d.front());
                    break;
                case 6:
                    System.out.println("Back = " + d.back());
                    break;
                case 7:
                    d.printHeadToTail();
                    break;
                case 8:
                    d.printTallToHead();
                    break;
                case 9: d.clear();
                    break;
                default:
                    System.out.println("Wrong action, ignore");
            }
        }
    }
}
