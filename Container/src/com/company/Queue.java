package com.company;

class Queue {
    private int[] array;
    private int size, head, tail;

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }
    public Queue(int size) {
        array = new int[size];
        clear();
    }
    public boolean empty() {
        return size == 0;
    }
    public void clear() {
        size = head = 0;
        tail = array.length - 1;
    }
    public void push(int val) throws Exception {
        if(++size > array.length) throw new Exception();
        array[tail=forward(tail)] = val;
    }
    public int pop() throws Exception {
        int val = front();
        head = forward(head);
        size -= 1;
        return val;
    }
    public int front() throws Exception {
        if(empty()) throw new Exception();
        return array[head];
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
