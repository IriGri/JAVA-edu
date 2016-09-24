package edu.stqa.irigri.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(1, 6);
        Point p2 = new Point(8, 7);
        Point p3 = new Point(5, 10);
        Assert.assertEquals(p1.distance(p1, p2), 7.0710678118654755);
        Assert.assertEquals(p2.distance(p1, p2), 7.0710678118654755);
        assert p1.distance(p1, p2) == p2.distance(p1, p2);
        Assert.assertEquals(p1.distance(p1, p3), 5.656854249492381);
        Assert.assertEquals(p2.distance(p2, p3), 4.242640687119285);
    }

}
