package part1;

public class Basic {

	public static void main(String[] args) {


		String x[][]=new String[3][5];
		System.out.println(x.length);
		System.out.println(x[0].length);



		x[0][0]="A";
		x[0][1]="B";
		x[0][2]="C";
		x[0][3]="D";
		x[0][4]="E";

		x[1][0]="F";
		x[1][1]="G";
		x[1][2]="H";
		x[1][3]="I";
		x[1][4]="J";


		for (int i = 0; i < x.length; i++) 
		{
			for (int j = 0; j<x[0].length ; j++) 
			{
				System.out.print(x[i][j]);

			}
			System.out.println("");
		}



	}

}
