package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Queue q = new Queue(5);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            q.push(scanner.nextInt());
        }


        for (int i = 0; i < 5; i++) {
            System.out.println(q.pop());
        }
    }
}
