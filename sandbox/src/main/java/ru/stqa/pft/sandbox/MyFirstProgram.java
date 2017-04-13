package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a +" и " + r.b +" = " + r.area());

    System.out.println("Hello, world");


    Point p1 = new Point(0,0);
    //p1.x=0;
    //p1.y=0;

    Point p2 = new Point(5,0);
    //p2.x=5;
    //p2.y=0;

    System.out.println("Расстояние между двумя точками " + "("+p1.x+","+p1.y+")" + " и " + "("+p2.x +","+ p2.y+")"+" = "+ p1.distance(p2));

  }



  //public static double distance (Point p1,Point p2){
    //return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
  }





