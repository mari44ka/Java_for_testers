import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mari on 4/20/17.
 */
public class Equaiontest {

  @Test
  public void test0() {
    Equation e = new Equation(1, 1, 1);
    Assert.assertEquals(e.rootNumber(), 0);

  }


  @Test
  public void test1() {
    Equation e = new Equation(1, 2, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }


  @Test
  public void test2() {
    Equation e = new Equation(1, 6, 1);
    Assert.assertEquals(e.rootNumber(), 2);

  }
}