package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;
class Rectangle{
    void area(int a, int b){
        System.out.println("Area of Rectangle is "+(a*b));
    }
}
class Triangle{
    void area(int a, int b){
        System.out.println("Area of Rectangle is"+(0.5*a*b));
    }
}
public class Main {

    public static void main(String[] args) {
        Triangle t=new Triangle();
        t.area(5,3);
        Rectangle r=new Rectangle();
        r.area(10,20);
    }
}