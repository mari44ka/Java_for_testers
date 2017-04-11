package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    double l = 5;
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    double a =5;
    double b =6;
    System.out.println("Площадь прямоугольника со сторонами " + a +" и " + b +" = " + area(a,b));

    System.out.println("Hello, world");
  }

  public static double area(double len) {
    return len*len; }

  public static double area(double a, double b){
    return a*b;
  }
  }


