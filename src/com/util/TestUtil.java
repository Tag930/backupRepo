package com.util;

import java.util.ArrayList;

import part1.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getexceldata() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		
			try {
				reader = new Xls_Reader("C:\\Users\\STrange\\Desktop\\details.xlsx");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
			
			String email = reader.getCellData("Sheet1", "Email", rowNum);
			String pass = reader.getCellData("Sheet1", "Password", rowNum);
			//System.out.println(email);
			//System.out.println(pass);
			
			Object ob[] = {email,pass};
			myData.add(ob);
			
		}
		
		return myData;
	}

}
