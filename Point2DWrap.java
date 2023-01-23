package datastructures2018;

import java.util.*;

class Point {
 double x, y;
 Point(double x, double y) {
  this.x = x;
  this.y = y;
 }
}

class Point2DWrap {

 public static int orientation(Point p, Point q, Point r) {
  double val = (q.y - p.y) * (r.x - q.x) -
   (q.x - p.x) * (r.y - q.y);

  if (val == 0) return 0;
  return (val > 0) ? 1 : 2;
 }

 public static void convexHull(Point points[], int n) {
  // There must be at least 3 points
  if (n < 3) return;

  Vector < Point > hull = new Vector < Point > ();

  int l = 0;
  for (int i = 1; i < n; i++)
   if (points[i].y < points[l].y)
    l = i;


  int p = l, q;
  do {

   hull.add(points[p]);

   q = (p + 1) % n;

   for (int i = 0; i < n; i++) {

    if (orientation(points[p], points[i], points[q]) == 2)
     q = i;
   }

   p = q;

  } while (p != l);


  for (Point temp: hull)
   System.out.print(" (" + temp.x + ", " +
    temp.y + ") ");
 }

 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);

  System.out.print("Enter number of points:  ");
  int numPoints = input.nextInt();

  System.out.print("Enter points: ");

  Point points[] = new Point[numPoints];

  for (int i = 0; i < points.length; i++) {
   points[i] = new Point(input.nextDouble(), input.nextDouble());
  }
  int n = points.length;
  System.out.print("The convex hull is ");

  convexHull(points, n);

  input.close();
 }

}

