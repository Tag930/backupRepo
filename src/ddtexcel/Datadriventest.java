package ddtexcel;

import part1.Xls_Reader;

public class Datadriventest {

	public static void main(String[] args) {
			
		Xls_Reader reader = new Xls_Reader("C:\\Users\\STrange\\Desktop\\gamma.xlsx");
		
		
		int s = reader.getRowCount("sheet1");
		System.out.println("Row Count is " + s);
		
		String st = reader.getCellData("sheet1", 0, 2);
		System.out.println("String extracted " + st);

	}

}
