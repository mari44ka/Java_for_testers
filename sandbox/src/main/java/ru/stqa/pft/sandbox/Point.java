package ru.stqa.pft.sandbox;

/**
 * Created by Mari on 4/11/17.
 */
public class Point {
  public double x;
  public double y;

  public Point(double x, double y){
    this.x=x;
    this.y=y;

  }
  double distance (double x,double y){

    return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
  }

  double distance(Point p1){
    return distance(p1.x,p1.y);
  }
}
