package datastructures2018;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;

public class Exc22_09ConvexHull {
public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of points: ");
	int size = input.nextInt();
	
	System.out.print("Enter points: ");
	double[][] points = new double[size][2];
	
	for(int i = 0; i < points.length; i++){
		for(int j = 0; j < 2; j++){
			points[i][j] = input.nextDouble();
		}
	}
	ArrayList<Point2D> wrap = getConvexHull(points);
	for(int i = 0; i < wrap.size(); i++){
	System.out.print(wrap.get(i) + " ");
	}
}
public static ArrayList<Point2D> getConvexHull(double[][] s){
	ArrayList<Point2D> h = new ArrayList<>();
	// sort the array
	for (int i = 0; i < s.length; i++) {
		for (int j = i + 1; j < s.length; j++) {
			if (s[i][1] < s[j][1]) {
				double tempY = s[i][1];
				double tempX = s[i][0];
				s[i][1] = s[j][1];
				s[i][0] = s[j][0];
				s[j][1] = tempY;
				s[j][0] = tempX;
			} else if (s[i][1] == s[j][1]) {
				if (s[i][0] < s[j][0]) {
					double tempY = s[i][1];
					double tempX = s[i][0];
					s[i][1] = s[j][1];
					s[i][0] = s[j][0];
					s[j][1] = tempY;
					s[j][0] = tempX;
				}
			}
		}
	}
	ArrayList<Point2D> points = new ArrayList<>();
	for (int i = 0; i < s.length; i++) {
		points.add(new Point2D(s[i][0], s[i][1]));
	}
	// should be right most bottom point
	// add h0 to H.
	h.add(points.get(points.size() - 1));
	// points.remove(points.size()-1); // Remove h0 from points
	Point2D h0 = h.get(0);
	Point2D t0 = h0;
	Point2D t1 = points.get(1);
	
	while (!t1.equals(h0)) // Step 3
		{
		// Step 2: find the right t1
		for (int i = 0; i < points.size(); i++) {
			double side = (points.get(i).getX() - t1.getX()) * (t1.getY() - t0.getY())
					- (points.get(i).getY() - t1.getY()) * (t1.getX() - t0.getX());
			if (side > 0) // points.get(i) is on the right of the line from t0 to t1
			{
				t1 = points.get(i);
			} else if (side == 0) {

				if (points.get(i).distance(t0) > t1.distance(t0))

					t1 = points.get(i);

			}
		}
		h.add(t1);
		points.remove(t1);
		t0 = t1;
		t1 = points.get(0);
	}
	return h;
}
}
