package companies;

import java.time.Period;

public class Tide {

	public static void main(String[] args) {
		
		/**
		 * 
		 * petrol:   [1,2,3,4]
		 * distance: [4,3,2,1]
		 * 
		 * last = last+petrol[pos]
		 * last = last-dis[pos]
		 * ind: --> last
		 * 0        (-2)
		 * 1         -3
		 * 2         -2
		 * 3          1%4=1
		 * 
		 * petrol:   [1,2,3,4]
		 * distance: [4,3,2,1]
		 */
		int []petrol = {3,4,6,3,7,11};
		int[]dist =    {3,10,2,4,6,9};
		
		System.out.println(findStartingPetrolPump(petrol,dist));
		System.out.println(findStartingPetrolPump1(petrol,dist));
		
	}
	
	public static int findStartingPetrolPump(int []petrol, int []dist) {
		int n = petrol.length;
		int avg = 1;
		if(n==0 || n!=dist.length) {
			return -1;
		}
		int start = 0;
		int totalFuelPetrol = 0;
		for(int i=0;i<n;i++) 
		totalFuelPetrol+=petrol[i];
		
		int totalDist = 0;
		for(int i=0;i<n;i++) {
			totalDist+=dist[i];
		}
		boolean canFinish = false;
		if(totalDist/totalFuelPetrol<=1) {
			for(int i=0;i<n;i++) {
				//canFinish = moveNext(i,avg,petrol,dist,0,n,totalDist);
				
				if((canFinish = moveNext(i,avg,petrol,dist,0,n,totalDist))) {
					start = i;
					break;
					
				}
				
			}
		}
		if(canFinish) {
			return start;
		}else {
			return -1;
		}
		
	}
	
	
	
	
	
	private static boolean moveNext(
			int petrolPumpNo, int avg, int[] petrol, int[] dist, int fuel, int n, int totalDist) {
		if(n==0) {
			return true;
		}
		if(petrolPumpNo>=petrol.length) {
			petrolPumpNo = 0;
		}
		fuel = fuel+petrol[petrolPumpNo];
		if(totalDist/fuel<=avg) {
			return true;
		}
		if(fuel*avg>=dist[petrolPumpNo]) {
			fuel = fuel-dist[petrolPumpNo];
			totalDist = totalDist-dist[petrolPumpNo];
			petrolPumpNo++;
			return moveNext(petrolPumpNo,avg,petrol,dist,fuel,n-1,totalDist);
			
		}
		return false;
	}

	public static int findStartingPetrolPump1(int []petrol, int []dist) {
		int surplus = 0;
		int pos = 0;
		int minFuel = 1;
		int minPosition = 0;
		int n = petrol.length;
		if(n==0 || n!=dist.length) {
			return -1;
		}
		while(pos<n) {
			surplus = surplus+petrol[pos];
			surplus = surplus-dist[pos];
			pos++;
			if(surplus<minFuel) {
				minFuel = surplus;
				minPosition = pos%n;
			}
		}
		return minPosition;
	}
}
