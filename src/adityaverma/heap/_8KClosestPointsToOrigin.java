package adityaverma.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a list of points on the 2-D plane and an integer K. 
 * The task is to find K closest points to the origin and print them.

Note: The distance between two points on a plane is the Euclidean distance.

Example:
Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2

 * @author sramveer
 *
 */
public class _8KClosestPointsToOrigin {

	public static void main(String[] args) {
		int a[][] = {{1,3},{-2,2},{5,8},{0,1},{0,1}};
		int k = 2;
		new _8KClosestPointsToOrigin().closestPoints(a, k);
	}
	
	/**
	 * https://www.youtube.com/watch?v=XC4EotTewro&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8
	 * 
	 * e.g:  1->3
	 *      -2->2
	 *       5->8
	 *       0->1
	 *       
	 * distance: 10
	 *            8
	 *            89
	 *            1
	 * 
	 * which heap to make: take an example and see 
	 * 
	 * here : if we create min heap: 1,8,10,89  so if we pop then will be poping 1,8 if k=2 which are min distances
	 * hence we will create max heap so that we can pop max distance from origin
	 */
	public void closestPoints(int a[][], int k) {
		PriorityQueue<Origin>pq = new PriorityQueue<>(new Comparator<Origin>() {
			@Override
			public int compare(Origin o1, Origin o2) {
				return o2.getDistance()-o1.getDistance();
			}
			
		});
		
		for(int i=0;i<a.length;i++) {
				int x = a[i][0];
				int y = a[i][1];
				pq.add(new Origin(x*x+y*y, x, y));
				if(pq.size()>k) {
					pq.poll();
				}
		}
		while(!pq.isEmpty()) {
			Origin or = pq.poll();
			System.out.println("closest dist: "+or.distance+" x: "+or.getX()+" y: "+or.getY());
		}
	}
}

class Origin{
	int distance;
	int x;
	int y;
	Origin(int distance, int x, int y){
		this.distance = distance;
		this.x = x;
		this.y = y;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
