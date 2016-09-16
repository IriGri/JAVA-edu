package edu.stqa.irigri.sandbox;

public class Solution {

    public static void main(String[] args)
    {
      Point t1 = new Point(0,0);
      Point t2 = new Point(4,3);
      System.out.println(distance(t1,t2));

    }
    public static double distance(Point p1, Point p2){
      return  Math.sqrt(Math.pow(p2.x-p1.x, 2)+ Math.pow(p2.y-p1.y,2));
    }

    public static class Point {
      double x;
      double y;
      Point (double a, double b){
        x=a;
        y=b;
      }
    }
  }

