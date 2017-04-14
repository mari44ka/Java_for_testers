package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mari on 4/13/17.
 */

public class PointTest {

  @Test
  public void testDistance(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(5,0);

    Assert.assertEquals(p1.distance(p2),5.0);
  }
  @Test
  public void testDistance1(){
    Point p1 = new Point(-3,-8);
    Point p2 = new Point(3,2);

    Assert.assertEquals(p1.distance(p2),11.661903789690601);
  }
}






