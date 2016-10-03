package edu.stqa.irigri.sandbox;

public class Distance {
  public static void main(String args[]) {
  Point p1 = new Point(1, 6);
  Point p2 = new Point(8, 7);
    Point p3 = new Point(5, 10);

    System.out.println("Дистанция между точками = " + p1.distance(p2));
}
}