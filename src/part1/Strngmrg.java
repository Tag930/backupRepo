package part1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Strngmrg {
	private static String fileLocation = "";
	int lastIndex;
	public static String file = "";

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

		String tag;
		String link;
		String isccpath = null;
		StringBuffer sbf = new StringBuffer();
		CodeSource codeSource = Strngmrg.class.getProtectionDomain().getCodeSource();
		File jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		System.out.println(jarDir);

		fileLocation = jarDir;

		final String searchThisExtn = ".xlsx";
		final String searchThisExtn2 = ".iss";

		Strngmrg obj = new Strngmrg();

		obj.filecheckerold(jarDir);
		String p[] = { "C:\\Users\\STrange\\AppData\\Local\\Programs\\Inno Setup 6\\ISCC.exe",
				"C:\\Program Files (x86)\\Inno Setup 6\\ISCC.exe", "C:\\Program Files\\Inno Setup 6\\ISCC.exe" };
		String q[] = { "C:\\Users\\STrange\\AppData\\Local\\Programs\\Inno Setup 6\\",
				"C:\\Program Files (x86)\\Inno Setup 6\\", "C:\\Program Files\\Inno Setup 6\\" };

		for (int i = 0; i < 3; i++) {
			File file = new File(p[i]);
			if (file.exists()) {
				isccpath = q[i];
				// JOptionPane.showMessageDialog(null, "cmd.exe" +"/c" +"cd "+ isccpath+ " &&
				// iscc "+jarDir+"\\"+"demo.iss");
				System.out.println(isccpath);

			}
		}
		String p3 = "iscc " + "\"" + jarDir + "\\demo.iss" + "\"";
		String p4 = "iscc "  + jarDir + "\\demo.iss";
		System.out.println(p3);
		// System.exit(0);
		String st = obj.listFiles(fileLocation, searchThisExtn);
		String st2 = obj.listFiles(fileLocation, searchThisExtn2);
		System.out.println("First String: " + st);
		System.out.println("Second String: " + st2);

		Xls_Reader reader = new Xls_Reader(jarDir + "\\" + st);

		Boolean s = reader.isSheetExist("sheet1");
		System.out.println("Does sheet exists: " + s);

		if (s) {
			int rowc = reader.getRowCount("sheet1");

			int colc = reader.getColumnCount("sheet1");
			System.out.println("Colummn count : " + colc);
			System.out.println("Row count: " + rowc);
			for (int i = 2; i <= rowc; i++) {
				int j = 0;

				tag = reader.getCellData("sheet1", j, i);
				link = reader.getCellData("sheet1", j + 1, i);
				// System.out.println("Row i is: " + i);

				// System.out.println("Two text are: " + tag +" " + link);

				sbf.append(tag + " " + link);
				sbf.append("\n");
			}
			System.out.println(sbf);
			obj.listFiles(fileLocation, searchThisExtn2);
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(jarDir + "\\" + "demo.iss")));
			bwr.write(sbf.toString());

			Path path1 = Paths.get(jarDir + "\\" + st2);
			Charset charset = StandardCharsets.UTF_8;

			String content = new String(Files.readAllBytes(path1), charset);
			//System.out.println(content);
			bwr.write(content.toString());
			bwr.flush();
			bwr.close();

			// System.out.println(content);
			System.out.println("Content written");
		}



		//ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c","start","cd "+isccpath+ "&& "+p3);
		//pb.start();
		//pb.redirectErrorStream(true); 
		//Process pr =pb.start();
		//BufferedReader r = new BufferedReader(new InputStreamReader(pr.getInputStream())); 
		//String line; 
		//while (true) { 
		//	line=r.readLine();
		//	if (line == null) {
		//		break; }
		//	System.out.println(line);




		// Process p2= Runtime.getRuntime().exec("cmd.exe /C start cd "+ isccpath+ "&& "+p3);

		//  BufferedInputStream testOutput= new BufferedInputStream(pb.getInputStream());
		//  int read = 0; byte[] output = new byte[1024]; while ((read =
		//  testOutput.read(output)) != -1) { System.out.println(output[read]); }

		/*
		 * Scanner sc=new Scanner(p2.getInputStream()); while (sc.hasNext()) {
		 * System.out.println(sc.nextLine());
		 * 
		 * }
		 */



		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","cd "+isccpath+ "&& "+p3); 
		builder.redirectErrorStream(true);
		Process p1 =builder.start(); 
		BufferedReader r = new BufferedReader(new
				InputStreamReader(p1.getInputStream())); String line; while (true) { line
					=r.readLine(); if (line == null) { break; } 
					System.out.println(line);
				}


	}

	public void filecheckerold(String j) throws InterruptedException {
		File file1 = new File(j + "\\demo.iss");
		if (file1.exists()) {
			file1.delete();
			System.out.println("File existed : File deleted");
			Thread.sleep(1000);
		}

	}

	public String listFiles(String loc, String extn) {

		SearchFiles files = new SearchFiles(extn);

		File folder = new File(loc);

		if (folder.isDirectory() == false) {
			System.out.println("Folder does not exists: " + fileLocation);

		}

		String[] list = folder.list(files);

		if (list.length == 0) {
			JOptionPane.showMessageDialog(null, "There are no files with " + extn + " Extension", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			// System.out.println("There are no files with " + extn + " Extension");

		}

		for (String file1 : list) {
			// String temp = new StringBuffer(fileLocation).append(File.separator)
			// .append(file).toString(l);
			// String temp2= new
			// System.out.println("files : " + file);
			file = file1;
		}
		return file;
	}

	public class SearchFiles implements FilenameFilter {

		private String ext;

		public SearchFiles(String ext) {
			this.ext = ext;
		}

		@Override
		public boolean accept(File loc, String name) {
			if (name.lastIndexOf('.') > 0) {
				// get last index for '.'
				lastIndex = name.lastIndexOf('.');

				// get extension
				String str = name.substring(lastIndex);

				// matching extension
				if (str.equalsIgnoreCase(ext)) {
					return true;
				}
			}
			return false;

		}
	}
	/*
	 * Path path2 = Paths.get("C:\\Users\\STrange\\Desktop\\tera.txt"); Charset
	 * charset2 = StandardCharsets.UTF_8;
	 * 
	 * String content2 = new String(Files.readAllBytes(path2), charset2);
	 * System.out.println(content2);
	 * 
	 * Path path = Paths.get("C:\\Users\\STrange\\Desktop\\ISPPExample1.iss");
	 * Charset charset = StandardCharsets.UTF_8;
	 * 
	 * String content = new String(Files.readAllBytes(path), charset);
	 * System.out.println(content);
	 */

}
