package part1;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
	 Scanner scr= new Scanner(System.in);
	 int num;
	 System.out.println("Enter any Positive number :");
	 num = scr.nextInt();
	 
	 System.out.println("Entered number :" + num);
	 //54321
	// int j=num;
		/*
		 * while (j>0) { num=num*(j-1); System.out.println("Factorial :"+num); j--; }
		 */
	 
	 for (int i=num; i>=2; i--) {
		 
		 num=num*(i-1);
		// System.out.println("factor" + num);
	}
	 
	System.out.println("factor :" + num);
	

	}

}
