package edu.stqa.irigri.sandbox;

public class Point {

  public double x;
  public double y;

  public static void main(String args[]) {
    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = 1;
    p1.y = 6;
    p2.x = 8;
    p2.y = 7;
  }

    public static double distance(Point p1, Point p2){
      double z;
      z = Math.sqrt( Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2) );
      return z;

  }


}
