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
}
