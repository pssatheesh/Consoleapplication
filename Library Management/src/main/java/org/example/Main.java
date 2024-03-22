package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter you phone:");
        String email=scanner.next();
        System.out.println(Pattern.matches("\\d{10}+", email));
        System.out.println("Hello world!");
    }
}