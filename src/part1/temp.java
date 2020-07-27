package part1;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class temp {

	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		long n = 3452894; 
		temp obj = new temp();

		int s= obj.counter(n);
		System.out.print("Number of digits : " + s); 


	} 

	public int counter(long n) {

		int count=0;
		while (n!=0) {
			n=n/10;
			count++;

		}

		return count;

	}


}

