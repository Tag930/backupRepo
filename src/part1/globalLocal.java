package part1;

public class globalLocal {
	
	
	String name="Tom";
	int i =25;

	public static void main(String[] args) {
		
		globalLocal st =new globalLocal();
		System.out.println(st.name);
		System.out.println(st.sum(5,3));

	}
	
	public int sum (int i, int k) {
		int sum = i+k;
		return sum;
	}

}
