package part1;

import java.io.IOException;

public class test22 {

	public static void main(String[] args) {
		 
	     
	         ProcessBuilder pb = new ProcessBuilder("cmd");

	         try 
	         {
	             pb.start();
	             System.out.println("cmd started");
	         } 
	         catch (IOException e) 
	         {
	             System.out.println(e.getMessage());
	         }  
	     

	}

}
